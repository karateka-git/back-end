import Account.Account;
import taskOne.ListOperator;
import taskTwo.ThreadExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        System.out.println("ArrayList numbers");
        List<Integer> listNumber = new ArrayList<>();
        listNumber.add(21);
        listNumber.add(13);
        listNumber.add(18);
        listNumber.add(17);

        ListOperator<Integer> listOperator = new ListOperator<>();

        System.out.println("Max in range 0 to 3: " + listOperator.max(listNumber, 0, 3));
        System.out.println("Max in range 0 to 1: " + listOperator.max(listNumber, 0, 1));
        System.out.println("Max in range 1 to 3: " + listOperator.max(listNumber, 1, 3));

        System.out.println(listOperator.toString(listNumber)+'\n');
        listOperator.changeElementsPosition(listNumber, 0, 2);
        System.out.println(listOperator.toString(listNumber)+'\n');

        System.out.println("LinkedList Account");
        List<Account> listAccount = new LinkedList<>();
        listAccount.add(new Account(21));
        listAccount.add(new Account(13));
        listAccount.add(new Account(21));
        listAccount.add(new Account(14));

        ListOperator<Account> listOperatorAccount = new ListOperator<>();

        System.out.println("Max in range 0 to 3: " + listOperatorAccount.max(listAccount, 0, 3));
        System.out.println("Max in range 0 to 1: " + listOperatorAccount.max(listAccount, 0, 1));
        System.out.println("Max in range 1 to 3: " + listOperatorAccount.max(listAccount, 1, 3));

        System.out.println(listOperatorAccount.toString(listAccount)+'\n');
        listOperatorAccount.changeElementsPosition(listAccount, 0, 1);
        System.out.println(listOperatorAccount.toString(listAccount)+'\n');

        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(5000);
    }
}
