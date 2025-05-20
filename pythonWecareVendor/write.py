import datetime

#two lists to hold invoice details
#creating these allows us to create a single invoice for multiple transactions
sell_invoice_holder =[]
purchase_invoice_holder = []

#for unique file name
current_time = datetime.datetime.now()
filename_sales = "sales_" + str(current_time.year) + "-" + str(current_time.month) + "-" + str(current_time.day) + "-" + str(current_time.hour) + "-" + str(current_time.minute) + "-" + str(current_time.second) + ".txt"
filename_purchases = "purchases_" + str(current_time.year) + "-" + str(current_time.month) + "-" + str(current_time.day) + "-" + str(current_time.hour) + "-" + str(current_time.minute) + "-" + str(current_time.second) + ".txt"


def create_sales_bill(name):
    """
    Create a sales invoice and save it to a file

        Parameters:
        name (str): The name of the customer for the sales transaction

        Returns:
        None

        Raises:
        None
    """
    sales_file = open(filename_sales,"w")
    sales_file.write("-"*80 + "\n")
    sales_file.write(" "*30+"|| Sales Invoice ||\n")
    sales_file.write("-"*80 + "\n")
    sales_file.write("Customer's name: " + name + "\n")
    sales_file.write("Date of Transaction: "+ str(current_time) + "\n")
    sales_file.write("-"*80 + "\n")
    final_total_cost_sales = 0
    for each in sell_invoice_holder:
        sales_file.write("Product name: "+each["product"] + "\nBrand: " + each["brand"] + "\nPurchased Quantity: " + str(each["quantity"]) + "\t\tFree Items Obtained: " + str(each["freeItems"]) + "\t\tTotal Items: " + str(each["totalItems"]) + "\nRate: " + str(each["sellPrice"]) + "\nTotal Cost: " + str(each["totalCost"]) + "\n")
        sales_file.write("-"*80 + "\n")
        final_total_cost_sales = final_total_cost_sales + each["totalCost"]

    sales_file.write("Grand Total: " + str(final_total_cost_sales) + "\n")
    sales_file.write("-"*80 + "\n")
    sales_file.close()

def create_purchases_bill():
    """
    Create a purchase invoice and save it to a file
        Parameters:
        None

        Returns:
        None

        Raises:
        None
    """  
    purchase_file = open(filename_purchases,"w")
    purchase_file.write("-"*80 + "\n")
    purchase_file.write(" "*25+"|| Purchases Invoice ||\n")
    purchase_file.write("-"*80 + "\n")
    purchase_file.write("Date of Transaction: "+ str(current_time) + "\n")
    purchase_file.write("-"*80 + "\n")
    final_total_cost_purchases = 0
    for each in purchase_invoice_holder:
        purchase_file.write("Supplier's name: "+each["vendorName"] + "\nProduct name: "+each["product"] + "\nBrand: " + each["brand"] + "\nPurchased Quantity: " + str(each["quantity"]) + "\t\tRate: " + str(each["rate"]) + "\nTotal Cost: " + str(each["totalCost"]) + "\n")
        purchase_file.write("-"*80 + "\n")
        final_total_cost_purchases = final_total_cost_purchases + each["totalCost"]
                    
    purchase_file.write("Grand Total: " + str(final_total_cost_purchases) + "\n")
    purchase_file.write("-"*80 + "\n")
    purchase_file.close()


import read 
def update_orginal_file():
    """
    Update the original product data file with the latest inventory information.

        Parameters:
        None

        Returns:
        None

        Raises:
        None
    """  
    file = open("products.txt","w")
    for key in read.store_dict:
        list_of_value = read.store_dict[key]
        list_in_string = []
        for each in list_of_value:
            list_in_string.append(str(each))
        
        file.write(",".join(list_in_string) + "\n")
    file.close()