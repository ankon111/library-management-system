# Rest API for library management system

# How to run: 
Tools Needed: JRE, Mysql Server, Postman (optional)

Inside of the run folder you will find the all files that needed to run the api.
Then please follow these steps:

1. Place the “prod_application.properties” file just into C:\ drive.(C:\prod_application.properties)
   Then edit the file with necessary Database Configuration.

2. Run the Create Scripts.sql into the MySql Server.

3. Run the jar File with the following command line :
   java -jar library-management-system-spring-boot.jar

4. Import the Production - Library Management System.postman_collection.json file into Your postman.

5. In post man all of the url are self-explanatory except book Search.
    In search there are two parts
    {
      "keyWord":"t",
      "searchBy": "2"
    }
   e.g : This value will search for those Autor Name that contains letter “t” .
   
   keyWord : the string we want to search.
   searchBy: means The key word search in which particular section.
   Here 1 means by Book Name
        2 means by Author Name
        3 means by Book Category
        0 means all (keyword will not work it returns all book details when searchBy is 0)
   If Search by value is not these values then it will return all book details and keyword will not filter without these three specific        search by values.
