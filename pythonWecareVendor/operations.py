import read

#checks the product ID input by the user
def product_id_validation():
    """
    Validate and return a user-input product ID based on inventory data.

        Parameters:
        None

        Returns:
        - product (int): A valid product ID entered by the user

        Raises:
        None
    """
    inner_loop = True
    #looping this part until user provides a valid input
    while inner_loop == True:
        #handling exception if user inputs alphabets instead of integers
        try:
            product = int(input("Enter the product ID for sold product: "))
        except:
            print("Please enter a valid product ID")
            inner_loop = True
            continue

        if(product < 1 or product > len(read.store_dict)):
            inner_loop = True
            print("Please enter a valid product ID")
        else:
            inner_loop = False
    return product

#checks the input quantity
def quantity_validation(product):
    """
    Validate the input quantity

        Parameters:
        product (int): The ID of the product for which quantity is being entered.

        Returns:
        - quantity (int): The validated quantity entered by the user.

        Raises:
        None
    """
    inner_loop2 = True
    #looping this part until user provides a valid input
    while inner_loop2 == True:
        #handling exception if user inputs alphabets instead of integers

        try:
            quantity = int(input("Enter the quantity: "))
            if quantity < 1:
                print("Please enter a valid quantity")
                inner_loop2 = True
                continue
            inner_loop2 = False
        except:
            print("Please enter a valid quantity")
            inner_loop2 = True
            continue
    return quantity

#prints out the 'we dont have items' statement or statement about the offer
def calculate_quantity_and_free_items(product):
    """
    Calculate free items under the 'buy 3 get 1 free' offer and validate inventory availability.

        Parameters:
        product (int): The ID of the product being purchased
        quantity (int): The number of items the user wants to purchase

        Returns:
        tuple: A tuple containing:
            - free_items (int): The number of free items from the offer
            - total_items (int): The total number of items including free items.

        Raises:
        None
    """
    while True:
        quantity = quantity_validation(product)
        free_items = quantity // 3
        total_items = quantity + free_items
        if quantity < 1:
            print("Please enter a valid quantity.")
            continue
        elif total_items > int(read.store_dict[product][2]):
            print("We currently do not own that many items in our inventory. Please enter less quantity.")
            continue
        else:
            break

    #printing about free items if the quantity was enough for a free item
    #otherwise, just printing the purchase was successful
    if(quantity >= 3):
        print("We currently have a buy three, get one free offer going on. Hence, for your purchase of",quantity, "items, you have obtained ",free_items, "items for free\n")
    else:
        print("Your purchase of",quantity, "items was successful.\n")

    return free_items, total_items, quantity

#functions to check if the user wants to continue or not
def user_continue(ask = "Do you want to continue? (y/n): "):
    """
    Check if the user wants to continue

        Parameters:
        ask (str): The prompt message displayed to the user

        Returns:
        bool: True if the user enters 'y', False if the user enters 'n'

        Raises:
        None
    """  
    while True:
        user_input = input(ask).lower()
        if user_input == "y":
            return True
        elif user_input == "n":
            return False
        else:
            print("Please enter a valid option (y/n)")

#function to create a table like structure for a readable data for the restocking purpose (rates differ for sales and purchases)
def normal_table_preview():
    """
    Display a formatted table of products for restocking purposes using original purchase prices.

        Parameters:
        None

        Returns:
        None
    """
    print("-"*80)
    print("id \t name \t\t brand \t\t qty \t price \t origin")
    print("-"*80)

    #iterating through the dictionary to give a readable format with tabs spacing and new lines
    for key,value in read.store_dict.items():
        print(key,end="\t")
        for each in value:
            print(each,end="\t")
        print()
    print("-"*80)

#function to create a table like structure for a readable data for the sales purpose (rates differ for sales and purchases)
def sales_table_preview():
    """
    Display a formatted table of products with updated selling prices for sales purposes.

        Parameters:
        None

        Returns:
        None
    """ 
    print("-"*80)
    print("id \t name \t\t brand \t\t qty \t price \t origin")
    print("-"*80)

    for key, value in read.store_dict.items():
        sell_price = int(value[3]) * 2
        print(key, end="\t")
        print(value[0], end="\t")
        print(value[1], end="\t")
        print(value[2], end="\t")
        print(str(sell_price), end="\t")
        print(value[4])
    print("-"*80)