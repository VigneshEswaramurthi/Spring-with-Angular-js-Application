var app = angular.module('myApp', ['ngResource']);
 app.controller('UserController', ['$scope', '$resource', '$http',function($scope,$resource,$http) 
	{
	 
	 function fetchAllPersons()
	 {
	        $scope.usernames = $resource('welcomes'
	        ).query(function(data){return data;});
	    };
	    fetchAllPersons();
	    
	    $scope.refresh = function(){
	    	fetchAllPersons();
	    };
	 
	 $scope.create = function()
	 {
	    	User = $resource(
	    		    "doRegister",
	    		    {},
	    		     {method:'POST',isArray:false}
	    	);
	    	
	    	var userBean = {};
			
			userBean.username = $scope.myform.username;
			userBean.phone = $scope.myform.phone;
			userBean.email = $scope.myform.email;
			userBean.address = $scope.myform.address;
			userBean.password = $scope.myform.password;
			
			$scope.Message = User.save(userBean);
					
			$scope.myform.username="";
			$scope.myform.phone="";
			$scope.myform.email="";
			$scope.myform.address="";
			$scope.myform.password="";
	    };
	    
	    $scope.deleteRec = function(username)
		 {
	    	$http({
	    		url: "delete/"+username,
	    		method: 'DELETE',
	    		data: {username: $scope.myform.username},
	    		headers: {'Content-type': 'application/json;charset=utf-8'}
	    		}).then(function(response)
	    		{
	    		
	    			$scope.Messages = response;
	    		});
	    	
	    };	    
 }]);