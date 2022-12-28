<html>
      <head>
          <title>
              Login
          </title>
          <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        .Center{
            margin-top: 150px;
            margin-left:auto;
            margin-right: auto;
            width:70%;
            
        }
        .header{
            background-color: lightblue;
            height:35px;
        }
        .mid{
            background-color: #DBF3FA;
        }
        form{
            padding-top: 20px;
            
        }
        .footer{
            margin-top: 40px;
            background-color: lightblue;
            height:35px;
            
        }
        label{
            margin-left: 20px;
            
        }
        h4{
            margin-left: 20px;
            color:cornsilk
        }
        span{
            color:crimson;
        }
        a{
            font-size: small;
        }
        
        .required:after {
    content:" *";
    color: red;
  }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      </head>
    <body>
        <div class="Container">
            <div class="Center">
                <div class="header">
                     <h4>Login</h4>
                </div>
                <div class="mid">
                	<%@include file="alert.jsp"%>
                    <form action="login" method="post">
                        <div class="form-group row">
                          <label for="inputEmail3" class="col-sm-4 col-4 col-form-label">Username<span>*</span></label>
                          
                          <div class="col-sm-6 col-xs-12 mb-2">
                            <input type="text" class="form-control" id="inputEmail3" name="username">
                            <small></small>
                          </div>
                        </div>
                        <div class="form-group row mb-2">
                          <label for="inputPassword3" class="col-sm-4 col-4  col-form-label">Password<span>*</span></label>
                         
                          <div class="col-sm-6 col-xs-6">
                            <input type="password" class="form-control" id="inputPassword3" name="password">
                            <small></small>
                        </div>
                        </div>
                        <div class="row justify-content-center">
                            <a href="Registration.jsp">Forgotten Your Password?</a>
                        </div>
                        <div class="col-lg-12 footer">
                            <button type="submit" class="btn btn-primary btn-sm float-right">Login>></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>