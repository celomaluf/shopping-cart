var commonModule = angular.module('App.Common', []);

/* 
 * @WEB_URL
 */

commonModule.constant('BackendCfg',  {
	url: 'http://localhost:8080/shoppingCart/',
    setupHttp: function(http) {
        http.defaults.useXDomain = true;
        http.defaults.withCredentials = true;
    }
});

