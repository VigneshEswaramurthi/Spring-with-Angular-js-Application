<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="angular.min.js"></script>
<script type="text/javascript" src="angular-resource.js"></script>
 <script type="text/javascript" src="app.js"></script>

<title>Insert title here</title>
</head>
<body data-ng-app="myApp" data-ng-controller="UserController">
<form name="myform">
<div class="register">
<div class="form-group col-lg-7" >
  <label for="username" class="control-label">First Name:</label>
  <input type="text"  id="username" data-ng-model="myform.username" class="form-control" placeholder="Enter Firstname"/><br>
   <label for="phone" class="control-label">Phone:</label>
  <input type="text" id="phone" data-ng-model="myform.phone" class="form-control" placeholder="Enter phone no."/><br>
  <label for="email" class="control-label">Email:</label>
  <input type="text" id="email" data-ng-model="myform.email" class="form-control" placeholder="Enter email"/><br>
  <label for="address" class="control-label">Address:</label>
  <input type="text" id="address" data-ng-model="myform.address" class="form-control" placeholder="Enter address"/><br>
  <label for="password" class="control-label">Password:</label>
  <input type="password" id="password" data-ng-model="myform.password" class="form-control" placeholder="Enter password"/><br>
    <button type="submit" class="btn btn-primary" id="submit" data-ng-click="create()">Submit</button>
     <button type="submit" class="btn btn-primary" id="refresh" data-ng-click="refresh()">refresh</button>
</div>
<table border="1" width="50%" height="50%"> 
    <tr><th>user_name</th><th>phone</th><th>email</th><th>delete</th><th>edit</th></tr>
     <tr data-ng-repeat="user in usernames">
     <td><span data-ng-bind="user.username"></span></td>
      <td><span data-ng-bind="user.phone"></span></td>
       <td><span data-ng-bind="user.email"></span></td>
        <td><button data-ng-click="deleteRec(user.username)">delete</button>
        <td><button data-ng-click="editrecord(user.username)">edit</button>
       </tr>   
   </table>   
 {{Messages}}
<div class="form-group col-lg-7">
</div>
</div>
</form>
</body>
</html>