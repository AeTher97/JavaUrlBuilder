## JavaUrlBuilder
Helps building urls for Http methods.

# Usage
To create url you need to call :
```
new GetUrl.create(String SERVER_ADDRESS) 
```
In which SERVER_ADDRESS is address of the server starting with http:// or "https://".

# Adding path
To add path to server address call method :
```
Get.Url.addPath(Strin PATH)
```
Method adds PATH to the address and returns GetUrl object with that path. Example PATH = "/place/place".

# Adding parameter
To add parameter for get request call method :
```
Get.Url.addParameter(String KEY,String VALUE)
```
Method add KEY with value VALUE to the url accordingly to GET request convention.

# Building Url
To get url as a string call
```
Get.Url.build()
```
Returns String object containing your url.


