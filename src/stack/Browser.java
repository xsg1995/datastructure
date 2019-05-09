package stack;

/**
 * Created by xsg on 2019/5/9.
 */
public class Browser {

    //当前浏览页面
    private String currentPage;
    //存储后退的页面
    private MyStack<String> backStack;
    //存储前进的页面
    private MyStack<String> forwardStack;

    public Browser() {
        this.backStack = new MyStack<>();
        this.forwardStack = new MyStack<>();
    }

    /**
     * 打开一个新页面
     * @param page
     */
    public void viewNewPage(String page) {
        if(this.currentPage == null) {
            this.currentPage = page;
        } else {
            this.backStack.push(this.currentPage);
            this.currentPage = page;
            this.forwardStack.empty();
        }
        this.printCurrentPage();
    }

    /**
     * 回退
     */
    public void back() {
        String backPage = this.backStack.pop();
        if(backPage != null) {
            this.forwardStack.push(this.currentPage);
            this.currentPage = backPage;
        }
        this.printCurrentPage();
    }

    /**
     * 前进
     */
    public void forward() {
        String forwardPage = this.forwardStack.pop();
        if(forwardPage != null) {
            this.backStack.push(this.currentPage);
            this.currentPage = forwardPage;
        }
        this.printCurrentPage();
    }

    /**
     * 打印当前页面
     */
    private void printCurrentPage() {
        System.out.println("currentPage: " + this.currentPage);
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.viewNewPage("A");
        browser.viewNewPage("B");
        browser.back();
        browser.forward();
        browser.viewNewPage("C");
        browser.forward();
        browser.back();
        browser.forward();
    }
}
