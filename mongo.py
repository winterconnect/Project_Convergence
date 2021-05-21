from pymongo import MongoClient
## 
client = MongoClient('localhost', 27017)
db = client.burger_menu

db.table.insert_one({'cus_id':'blueko34', 'menu':'치즈버거 1개', 'price':'3500', 'togo':'yes', 'status':'완료'})
db.table.insert_one({'cus_id':'mary', 'menu':'불고기버거 1개', 'price':'4500', 'togo':'yes', 'status':'완료'})
db.table.insert_one({'cus_id':'John', 'menu':'더블버거 2개', 'price':'9000', 'togo':'yes', 'status':''})
db.table.insert_one({'cus_id':'Frank', 'menu':'치즈버거 1개', 'price':'3500', 'togo':'yes', 'status':'완료'})
db.table.insert_one({'cus_id':'chunk94', 'menu':'치즈버거 1개', 'price':'3500', 'togo':'yes', 'status':'완료'})


