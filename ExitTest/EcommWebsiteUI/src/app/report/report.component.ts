import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FilterDetails } from '../_model/filter-detail.model';
import { ProductService } from '../_services/product.service';
import jsPDF from 'jspdf';
import html2canvas  from 'html2canvas';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  brandNames:[]=[];
  categoryNames:[]=[];
  salesReport:[]=[]

 filterDetails:FilterDetails={
  brandName:"",
  categoryType:"",
  startDate:new Date(),
  endDate:new Date()
 }
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getBrandName().subscribe(
      (resp)=>{
        
        this.brandNames=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
    this.productService.getCategoryName().subscribe(
      (resp)=>{
        
        this.categoryNames=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
    
  }

  public foundSales(SalesForm : NgForm){
    this.productService.getSalesReport(this.filterDetails.brandName,this.filterDetails.categoryType, this.filterDetails.startDate,this.filterDetails.endDate).subscribe(
      (resp)=>{
        console.log(resp);
        this.salesReport=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  public openPDF(): void{
    let DATA: any= document.getElementById("salesReport");
    html2canvas(DATA).then((canvas)=>{
      let fileWidth=208;
      let fileHeight=(canvas.height* fileWidth)/ canvas.width;
      const FILEURI = canvas.toDataURL('image/png');
      let PDF = new jsPDF('p',"mm",'a4');
      let position=0;
      PDF.addImage(FILEURI,'PNG',0,position,fileWidth,fileHeight);
      PDF.save('sales-report.pdf');
    }
    );
  }

}