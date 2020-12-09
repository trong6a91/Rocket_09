-- Question 1
SELECT c.`Name`,s.`Name`
FROM countryregion c JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;

-- Question 2
SELECT c.`Name`,s.`Name`
FROM countryregion c JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` LIKE 'Canada%' OR c.`Name` LIKE 'Germany%';

-- Question 3
SELECT a.SalesOrderID,a.SalesPersonID,a.OrderDate,b.Bonus,b.SalesYTD
FROM salesorderheader a JOIN salesperson b ON a.SalesPersonID=b.SalesPersonID;
