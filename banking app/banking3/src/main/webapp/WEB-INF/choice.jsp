<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <link href="css/choice.css" rel="stylesheet"></link>
    <script src="func.js">  </script>
    <title>choose</title>
    </head>
    <body>
     <div class="container">
        
    <div class="create">
    <h1 class="new_users " onclick="func()">
        <i class="fa-solid fa-user-plus"></i> Create New User 
    </h1>

   </div>
   <script>
    function func() {
        window.location.href = "create.html";
    }
   </script>
    <div class="edit_users">

        <h1 class="edit">
            <i class="fa-solid fa-user-plus"></i>edit
        </h1>
    </div>

    </div>

    </body>
    </html>