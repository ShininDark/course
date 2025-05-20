import read
import write
import operations

#creating a friendly welcome screen
print("\t\t\t   || We Care Vendor ||")
print("\t\t       || Bhainsepati, Lalitpur ||")
print("\n")

#calling the function from read.py
read.read_file()

#displaying the current inventory with the rates of selling to the user
operations.sales_table_preview()

options_loop = True
count = 1   #count variable to not repeat Enter name input for every new item.
while options_loop == True:
    print("\nWhat do u want to do?")
    print("Enter 1 to display the current inventory")
    print("Enter 2 to sell the product")
    print("Enter 3 to purchase products")
    print("Enter 4 to exit the program.\n")

    #Take the input from the user
    while True:
        try:
            choice = int(input("Enter your choice: "))
            break
        except:
            print("Enter a valid input!")
            continue

    #creating operations for each choice
    if choice == 1:
        print("\nThis is our current inventory")
        operations.sales_table_preview()
        continue

    #code for second choice(selling products)
    elif choice == 2:
        bool_for_continue = True
        while bool_for_continue == True:
            print("\nThese are our available products:")
            operations.sales_table_preview()
            
            if(count == 1):
                name = input("Enter your name: ")

            #calls function from operations.py to check the product ID
            product = operations.product_id_validation()

            #calls function from operations.py to check the quantity
            free_items, total_items, quantity = operations.calculate_quantity_and_free_items(product)
            

            #updating items in inventory
            read.store_dict[product][2] = int(read.store_dict[product][2])-total_items
            sell_price = int(read.store_dict[product][3])*2
            total_cost = quantity*sell_price

            #storing the details in the list
            write.sell_invoice_holder.append({"name":name, "product":read.store_dict[product][0], "brand":read.store_dict[product][1], "quantity":quantity, "freeItems":free_items,"totalItems":total_items, "sellPrice":sell_price, "totalCost":total_cost})
            count += 1      #increasing count to stop asking the name for another item purchase

            bool_for_continue = operations.user_continue("Do you want to continue? (y/n): ")

    #code for third choice (purchasing for restock)
    elif choice == 3:
        bool_for_continue = True
        while bool_for_continue == True:
            print("\nThis is our current inventory")
            operations.normal_table_preview()

            product = operations.product_id_validation()
            quantity = operations.quantity_validation(product)

            vendor_name = input("Enter the name of the supplier of the product: ")

            #updating items in inventory
            read.store_dict[product][2] = int(read.store_dict[product][2])+quantity
            purchase_price = int(read.store_dict[product][3])

            write.purchase_invoice_holder.append({"vendorName":vendor_name, "product":read.store_dict[product][0], "brand":read.store_dict[product][1], "quantity":quantity, "rate":purchase_price, "totalCost":quantity * purchase_price})

            #calling the continue function
            bool_for_continue = operations.user_continue("Do you want to continue? (y/n): ")

    #when the user wants to exit out of the system
    elif choice == 4:
        
        #if tthe user has sold something, this will create a sales invoice
        #if the user hasnt sold anything, this will not create a sales invoice
        if(len(write.sell_invoice_holder) > 0):
            write.create_sales_bill(name)

        #if the user has purchased something, this will create a purchases invoice
        #if the user hasnt purchased anything, this will not create a purchases invoice
        if(len(write.purchase_invoice_holder) > 0):
            write.create_purchases_bill()
        
        write.update_orginal_file()

        print("\nThank you for using our system!\n"+"="*9+"\nGoodBye!!\n"+"="*9)
        options_loop = False

    #when input choice is not an available choice
    else:
        print("Please enter a valid option: (1, 2, 3 or 4) as per your requirement.\n")
