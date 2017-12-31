var app=angular.module("myBanqueApp",[])
app.controller("myBanqueController", function($scope,$http){
	$scope.compte=null;
	$scope.codeCompte=null;
	$scope.operation={type:"versement",montant:0}
	$scope.chargerCompte=function(){
		  $http.get("/comptes/"+$scope.codeCompte)
		  .success(function(data){
			  $scope.compte=data;
		  });
	};
	$scope.saveOperation=function(){
	  	
	};
});