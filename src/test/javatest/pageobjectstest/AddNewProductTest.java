
    /**
     * <b>TC-03: Positive Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */
    @Test
    public void checkRequiredFieldsWithCorrectDataTest(){
         String actualMessage = adminProductsList
                 .goToAddNewProduct()
                 .setProductName("test123324")
                 .setMetaTagTitle("test12321")
                 .clickData()
                 .setProductModel("test")
                 .saveNewProduct()
                 .getTextFromMessage();
         assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-04: Positive Test For Required Fields with Numbers.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithNumbersDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("23413245643")
                .setMetaTagTitle("1232435436")
                .clickData()
                .setProductModel("1243245346")
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-05: Positive Test For Required Fields With Symbols.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithSymbolsDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("+_++_+^#$%^")
                .setMetaTagTitle("+_)(*&^%")
                .clickData()
                .setProductModel("_)(*&^%$#@")
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-06: Positive Test For Required Fields with spaces.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Fill Product Name field;
     * <li>3. Fill Mega Tag field;
     * <li>4. Fill Product Model field;
     * <li>5. Click Save Product button;
     * <li>6. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result: Success: You have modified products.
     */

    @Test
    public void checkRequiredFieldWithSpaceDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("   ")
                .setMetaTagTitle("    ")
                .clickData()
                .setProductModel("    ")
                .saveNewProduct()
                .getTextFromMessage();
        assertTrue(actualMessage.contains(SUCCESS_CHANGING_PRODUCT));
    }

    /**
     * <b>TC-08: Negative Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Product Name field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * Expected Result:"Product Name must be greater than 1 and less than 255 characters".
     */

    @Test
    public void checkProductNameWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setProductName("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

    /**
     * <b>TC-09: Positive Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Mega Tag field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * "Warning: "Product Name must be greater than 1 and less than 255 characters".
     */

    @Test
    public void checkMegaTagFieldWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .setMetaTagTitle("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

    /**
     * <b>TC-10: Negative Test For Required Fields.</b>
     *
     * Scenario:
     * <ul>
     * <li>1. Click on Add New Product Button;
     * <li>2. Click on Product Model field;
     * <li>3. Click Save Product button;
     * <li>4. Compare actual and expected messages;
     * </ul>
     * <p>
     * "Warning: "Product Name must be greater than 1 and less than 255 characters".
     */

    @Test
    public void checkProductModelWithoutDataTest(){
        String actualMessage = adminProductsList
                .goToAddNewProduct()
                .clickData()
                .setProductModel("")
                .saveNewProductWithMistake()
                .getMessageFromField();
        addProduct.goBackToList();
        assertTrue(actualMessage.contains(NEGATIVE_MESSAGE_FOR_FIELD));
    }

}