
#initializing an empty dictionary
store_dict = {}


def read_file():
    """
    Read the product data from a file and store it in a dictionary for later use.

        Parameters:
        None

        Returns:
        None

        Raises:
        None
    """
    #opening the file 
    file = open("products.txt","r")
    data = file.readlines()
    #storing product id value as 1 for first line
    product_id = 1

    #iterating through the lines of the file
    for line in data:
        
        line = line.replace("\n","").split(",")     #replaces every \n with nothing
        store_dict[product_id] = line       #stores the entire line in productID
        product_id += 1

    file.close()