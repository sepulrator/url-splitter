# URL Splitter

##### Regular Expression Algorithm

This is a modified version of regex written by Berners-Lee for [parsing uri reference](https://tools.ietf.org/html/rfc3986#appendix-B)

```
^(([^:/?#]+):)?(//([^/?#]*)/?)?([^?#]*)(\?([^#]*)?)?
 12            3  4            5       6  7         
 Example:
 for https://www.playtech.com:443/services?marketing_services
 
 $1 = https:
 $2 = https
 $3 = //www.ics.uci.edu:443
 $4 = www.playtech.com:443
 $5 = services
 $6 = ?marketing_services
 $7 = marketing_services
 	       
```

##### State Machine Algorithm

Enum based state machine pattern is used for that part. 

States are START,SCHEME,HOST,PORT,PATH,PARAMETERS,END
  
```

#### Build and Run
```bash
> mvn clean install
> java -jar target/splitUrl.jar "https://www.playtech.com:443/services?marketing_services"
```

#### Test Cases
> java -jar target/splitUrl.jar "https://www.playtech.com:443/services?marketing_services"
> java -jar target/splitUrl.jar "https://www.playtech.com/services?marketing_services"
> java -jar target/splitUrl.jar "https://www.playtech.com:443/services"
> java -jar target/splitUrl.jar "https://www.playtech.com/services"