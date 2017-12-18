## Assignment 1

Assumption: collection name=> animals

	db.animalsf.find({'firstNumber':{'$lt':10000}, 'secondNumber':{'$gt': 5000}}, {'firstNumber':1, 'thirdNumber':1}).sort({'thirdNumber':-1})

For the above query the time required for different indexes are:



1. firstNumber_1_secondNumber_1

		db.animals.find( {"firstNumber":{'$lt':10000},"secondNumber":{'$gt':5000}}, {"firstNumber":1,"thirdNumber":1}).sort({"thirdNumber":-1}).hint('firstNumber_1_secondNumber_1').explain();

	Execution Time: 44 ms

2. firstNumber_1_thirdNumber_1

 		 db.animals.find( {"firstNumber":{'$lt':10000},"secondNumber":{'$gt':5000}}, {"firstNumber":1,"thirdNumber":1}).sort({"thirdNumber":-1}).hint('firstNumber_1_thirdNumber_1').explain();
	
	Execution Time: 37 ms

3. thirdNumber_1

		 db.animals.find( {"firstNumber":{'$lt':10000},"secondNumber":{'$gt':5000}}, {"firstNumber":1,"thirdNumber":1}).sort({"thirdNumber":-1}).hint('thirdNumber_1').explain();

	Execution Time: below 32 ms

4. firstNumber_1_secondNumber_1_thirdNumber_-1

		db.animals.find( {"firstNumber":{'$lt':10000},"secondNumber":{'$gt':5000}}, {"firstNumber":1,"thirdNumber":1}).sort({"thirdNumber":-1}).hint('firstNumber_1_secondNumber_1_thirdNumber_-1').explain();

	Query Execution Time: 46ms

5. id

	db.animals.find({'firstNumber':{'$lt':10000}, 'secondNumber':{'$gt': 5000}}, {'firstNumber':1, 'thirdNumber':1}).sort({'thirdNumber':-1}).hint('_id_').explain()
	
Execution Time: 38 ms

----

----


## Assignment 2

Options

	1.Add an index on last_name, first_name if one does not already exist. 
	2.Remove all indexes from the collection, leaving only the index on _id in place 
	3.Provide a hint to MongoDB that it should not use an index for the inserts 
	4.Set w=0 on writes 
	5.Build a replica set and insert data into the secondary nodes to free up the primary nodes. 

**Answer**
In general, the performance gains that indexes provide for read operations are worth the insertion penalty. However, in order to optimize write performance when possible, be careful when creating new indexes and evaluate the existing indexes to ensure that your queries actually use these indexes.

     1. Is not correct, as adding an index impose overhead on insert operation,as after every insert, update, or delete operation, MongoDB must update every index associated with the collection
     2. Correct, as stated in 1
     3. Is not correct, as there is no way to tell mongo db to temporarily disable indexes 
     4. Correct, as it wont have to wait for the write acknowledgement, however data may not be as reliable
     5. Is not correct, as it is not possible to write on secondary nodes
     
----

----
  
## Assignment 3

**Answer : 1**

On execution, the following error occurs and only one record is added:

	E11000 duplicate key error collection: test.animals index: _id_ dup key: { : ObjectId('5a368281676d3913522dce67') }
















 
 
 

  

