/**
 * Class for item.
 */
public class Item {
    /**
     * { var_description }.
     */
    String productName;
    /**
     * { var_description }.
     */
    int productquantity;
    /**
     * { var_description }.
     */
    double unitPrice;
    /**
     * Constructs the object.
     *
     * @param      productName1      The product name
     * @param      productquantity1  The productquantity
     * @param      unitPrice1       The unit price
     */
    Item(final String productName1, final String productquantity1,
            final String unitPrice1) {
        this.productName = productName1;
        this.productquantity = Integer.parseInt(productquantity1);
        this.unitPrice = Double.parseDouble(unitPrice1);
    }
    /**
     * Constructs the object.
     *
     * @param      productName1      The product name
     * @param      productquantity1  The productquantity
     */
    Item(final String productName1, final String productquantity1) {
        this.productName = productName1;
        this.productquantity = Integer.parseInt(productquantity1);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productName + " "
            + this.productquantity + " " + this.unitPrice;
    }
    /**
     * { function_description }.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Item other) {
        if (!this.productName.equals(other.productName)) {
            return false;
        }
        return true;
    }
}
/**
 * Class for shopping cartesian.
 */
 class ShoppingCart {
    /**
     * { item_description }.
     */
    private int size1, size2, k = 1;
    /**
     * { item_description }.
     */
    private Item[] catalog, cart;
    /**
     * { var_description }.
     */
    private String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
    /**
     * { var_description }.
     */
    private static double discount = 0.0;
    /**
     * { var_description }.
     */
    private static boolean couponApplied = false;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        final int var8 = 20;
        catalog = new Item[var8];
        cart = new Item[var8];
        size1 = 0;
        size2 = 0;
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        catalog[size1++] = item;
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        if (!inCart(item)) {
            if (checkCatalog(item)) {
                cart[size2++] = item;
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    private boolean checkCatalog(final Item item) {
        for (Item i : catalog) {
            if (i != null) {
                if (i.equals(item)) {
                    if (item.productquantity <= i.productquantity) {
                        i.productquantity = i.productquantity
                        - item.productquantity;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (int i = 0; i < size2; i++) {
            if (item.equals(cart[i])) {
                cart[i].productquantity = cart[i].productquantity
                    - item.productquantity;
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    boolean inCart(final Item item) {
        for (Item s : cart) {
            if (s != null) {
                if (s.equals(item)) {
                    s.productquantity = s.productquantity
                        + item.productquantity;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (Item i : cart) {
            if (i != null) {
                if (i.productquantity != 0) {
                    System.out.println(i.productName + " " + i.productquantity);
                }
            }
        }
    }
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (Item i : catalog) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
    /**
     * Gets the price.
     *
     * @param      item  The item
     *
     * @return     The price.
     */
    double getPrice(final Item item) {
        for (Item i : catalog) {
            if (i != null) {
                if (i.equals(item)) {
                    return i.unitPrice;
                }
            }
        }
        return 0.0;
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < size2; i++) {
            total += cart[i].productquantity * getPrice(cart[i]);
        }
        return total;
    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        final int var5 = 15;
        final int var6 = 100;
        double total = getTotalAmount();
        double newTotal = total - discount;
        double tax = newTotal * var5 / var6;
        return newTotal + tax;
    }
    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        // double discount = 0.0;

        if (couponApplied) {
            // System.out.println("Invalid coupon");
            return;
        }
        final int var3 = 3;
        final int var4 = 100;
        boolean valid = false;
        if (k == 1) {
            for (String s : validCoupons) {
                if (s.equals(coupon)) {
                    int num = Integer.parseInt(coupon.substring(var3));
                    discount = getTotalAmount() * num / var4;
                    valid = true;
                    couponApplied = true;
                    k++;
                }
            }
        }
        if (!valid) {
            System.out.println("Invalid coupon");
            return;
        }
    }
    /**
     * { function_description }.
     */
    void printInVoice() {

        System.out.println("Name   quantity   Price");
        for (Item i : cart) {
            if (i != null) {
                if (i.productquantity != 0) {
            System.out.println(i.productName + " "
                + i.productquantity + " " + getPrice(i));
        }
    }
    }
        final int var1 = 15;
        final int var2 = 100;
        double total = getTotalAmount();
        double newTotal = total - discount;
        double tax = newTotal * var1 / var2;
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount: " + getPayableAmount());
    }
}