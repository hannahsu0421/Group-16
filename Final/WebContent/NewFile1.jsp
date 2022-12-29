<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travegle</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="./searchpage.css">
</head>
<body>
	<form action='${requestUri}' method='get'>
	    <div><img src="./前端素材/f2-unscreen.gif" alt="" class="icon"></div>
	    <div><h1 class="name">Travegle</h1></div>
	    <div><input type="text" placeholder="&#xF002; type something to search" class="search-bar" style="font-family:Arial, FontAwesome"/></div>
		
		<!--助教的 -->
		
		<div style='position: absolute;margin-top:190px;margin-left:50px'>
			<%
			String[][] orderList = (String[][]) request.getAttribute("query");
			for (int i = 0; i < orderList.length; i++) {
				String s=orderList[i][1];
				s=s.substring(7);
			%>
			
			<a href='<%=s%>'><%=orderList[i][0]%> </a> <br>連結<br>
			<br>
			<%
	}
	%>
		</div>
		<div>
			<img src="images/band-2.png"
				style='position: absolute; width: 150px; height: 100px; left: 50%; top: 50%; margin-top: -280px; margin-left: -590px'>
		</div>
			<div>
			<input type='text' class="border-style" id="padding" name='keyword'
				style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -250px; margin-left: -400px; width: 800px; height: 25px'
				placeholder = '請輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
		</div>

	</form>
	
	<!--助教的 -->
	
	
    <!-- css 放裡面 -->
    <style>
    <!--助教的 -->
	    a {
		color: #0B173B;
		font-size: 30px;
		text-decoration: none;
		}
		a:hover{
		text-decoration:underline;
		}
		.border-style {
			border-radius: 90px/90px;
		}
		    
	<!--助教的 -->
	
	
        @import url('https://fonts.googleapis.com/css2?family=Poppins&family=Noto+Sans+TC:wght@500&display=swap');
        @import url(//fonts.googleapis.com/earlyaccess/notosanstc.css);
        *{
            font-family: 'Poppins', cursive,'Noto Sans TC';
            font-family: 'Noto Sans TC', '微軟正黑體', sans-serif;
            box-sizing: border-box;
        }

        html {
            height: 100%;
        }

        body {
            background-image: url(./前端素材/pexels-pixabay-235985.jpg);
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;
        }
        .icon{
            width: 150px;
            bottom: 20%;
            position: absolute;
            top: 8%; 
            left: 7%;

        }

        .name{
            font-size: 30px;
            color: aliceblue;
            text-shadow: -1px -1px 0 white, 1px 1px 0 #333,1px 1px 0 #444;
            margin-left: 8%;
            margin-top: 2%;
            float: left;
        }

        .search-bar{
            text-align: center;
            background-color:  rgb(247, 241, 233);
            opacity: 1;
            border: none;
            border-radius: 15px;
            width: 40%;
            height: 30px;
            margin-left: 2%;
            margin-top: 2.2%;
            float: left;
        }

        .search-bar:hover{
            text-align: center;
            background-color: rgb(255, 255, 255);
            opacity: 1;
            box-shadow: 0px 20px 18px rgba(15, 15, 15, 0.411);
            border-radius: 25px;
            border: none;
            width: 40%;
            height: 35px;
            transition: all .3s ease;
        }

        /*去掉點擊的黑外框*/
        input{
            border:0;
            outline:0;
        }

        input:focus{
            outline:none!important;
        }

        /*placeholder預設灰字改顏色*/
        ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
            color: rgb(148, 148, 148);
            opacity: 1; /* Firefox */
            font-size: 10px;
        }

        @media(max-width:600px){
            .icon{
                display: none;
            }
        }
    </style>
</body>
</html>