class BackGround extends Thread{
    public void run(){
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
            if (true) {
                while (true) {
                    ArrowKeyMenu.amountOfCookies++;
                    ArrowKeyMenu.textAreaCookieAmount.setText("Cookies =" + ArrowKeyMenu.amountOfCookies);
                    ArrowKeyMenu.menu.revalidate();
                    ArrowKeyMenu.menu.repaint();
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println("No sleep");
                    }
                }
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
