USE adventureworks;

-- Question 1
SELECT `Name`
FROM product
WHERE ProductSubcategoryID = (SELECT ProductSubcategoryID
								FROM productsubcategory
                                WHERE `Name` ='Saddles');

-- Question 2
SELECT `Name`
FROM product
WHERE ProductSubcategoryID IN (SELECT ProductSubcategoryID
								FROM productsubcategory
                                WHERE `Name` LIKE 'Bo%' );
         
-- Question 3
SELECT `Name`
FROM product
WHERE ListPrice = (SELECT MIN(ListPrice) 
					FROM product
                    WHERE ProductSubcategoryID = (SELECT ProductSubcategoryID
													FROM productsubcategory
                                                    WHERE `Name`= 'Touring Bikes'));