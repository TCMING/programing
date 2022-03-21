package real;

import java.util.*;

public class Consumer {
//    def create_customer(amount:int) -> str
//    def create_customer_with_referer(amount:int, referer: str) -> str
//# sorted list of customer ids (sort by total amount)
//    def list_customers_by_total_amount(k: int, min_total_amount: int) -> List[str]
    int id = 0;
    //TreeMap  customer = new TreeMap();
    Map<String,Customer> customers = new HashMap<>();

    // 空间O(n) 存储用户集  时间O(1)
    public String create_customer(int amount){
        String name = String.valueOf(getId());
        Customer customer =  new Customer(amount,name);
        customers.put(name,customer);
        return name;
    }
    // 空间O(n) 存储用户集  时间O(1)
    public String create_customer_with_referer(int amount,String referer){
        String name = String.valueOf(getId());
        Customer customer = customers.get(referer);
        if(customer != null){
            amount += customer.amount;
        }
        Customer newCustomer =  new Customer(amount,name);
        customers.put(name,newCustomer);
        return name;
    }
    // 空间O(n) 存储用户集  时间O(nlog(n))
    public List<String> list_customers_by_total_amount(int k,int min_total_amount){
        List<Customer> customerList = new ArrayList<>(k);
        for(Map.Entry<String,Customer> entry : customers.entrySet()){
            //TODO 是否包括 min_total_amount？
            if(entry.getValue().amount >= min_total_amount){
                customerList.add(entry.getValue());
            }
        }

        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.amount - o2.amount;
            }
        });
        List<String> result = new LinkedList<>();
        int len = Math.min(k,customerList.size());
        for(int i=0; i < len; i++){
            result.add(customerList.get(i).name);
        }
        return result;
    }

//            List<Customer> customerList = new ArrayList<>(k);
//        //初始化
//        for(int i=0; i < k; i++){
//            customerList.add(new Customer(Integer.MIN_VALUE,0));
//        }
////        //选出前k个账户
////        for(Map.Entry<String,Customer> entry : customers.entrySet()){
////            //TODO 是否包括 min_total_amount？
////            if(entry.getValue().amount >= min_total_amount && entry.getValue().amount > customerList.get(0).amount){
////                customerList
////            }
////        }
////        //k个账户排序
//
//    public void adjust(List<Customer> customerList,Customer customer){
//        int position = 0;
//        while(){
//
//        }
//
//    }

    public int getId() {
        return id++;
    }
}


class Customer{

    public int amount;

    public String name;

    public Customer(int amount,String name) {
        this.amount = amount;
        this.name = name;
    }
}
