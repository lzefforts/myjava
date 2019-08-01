import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.layout.LoggerFields;
import org.study.PageTool;
import org.study.howHttpClientWorks.ParentClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{

    private static Log log = LogFactory.getLog(Main.class);
    private static int num = 1;
    static {
        num = 2;
//        System.out.println(num);
    }


    public static void testA(PageTool<String> list){
        System.out.println("testA");
        System.out.println("length:"+list.getRecords().size());
        testB(list);
        System.out.println("length:"+list.getRecords().size());
    }


    private static void testB(PageTool<String> list){
        System.out.println("testB");

        List<String> oldList = list.getRecords();
        List<String> newList = new ArrayList<>();
        for(int i=0;i<oldList.size()-2;i++){
            newList.add(oldList.get(i));
        }

        list.setRecords(newList);


    }


    PageTool pageTool = new PageTool();

    public void test(){
        pageTool.setPageSize(28);
        System.out.printf("pageSize:%s\n",pageTool.getPageSize());
    }



    public static void main(String[] args) {
//        Boolean flag = true;
//        log.info("###main,begin");
//        Main main = new Main();
//        main.test();
//        log.info("###main,end");

        int a = 1;
        Integer b = new Integer(1);
        System.out.println(b.equals(a));

        Map<Double, Object> map = new HashMap<>();
        map.put(0.4, new Object());
        System.out.println(map.get(0.4));


//        System.out.println(Long.MAX_VALUE+"");
//        System.out.println("1138279212273111040".length());
//
//        Long result = Long.valueOf("11111111112222222222");
//        System.out.printf(result.toString());



//        System.out.println("Hello World!");
//
//        Optional param = Optional.of(null);
//        System.out.printf(""+param.isPresent());

//        南方骥元-中石化混合所有制改革3号专项资产管理计划
//        南方骥元－中石化混合所有制改革３号专项资产管理计划

//        char[] array = {'3','３','a','-','－'};
//        for(char a : array){
//            System.out.println(Integer.valueOf(a));
//        }


//        BigDecimal a = BigDecimal.valueOf(124.5);
//        BigDecimal b = BigDecimal.valueOf(2.1);
//        BigDecimal result = a.divide(b).setScale(4,BigDecimal.ROUND_HALF_UP);
//        BigDecimal c = a.divide(b,4,BigDecimal.ROUND_HALF_UP);
//        System.out.println("result:"+result);
//        System.out.println("c:"+c);


//        System.out.println(3/2);
//        System.out.println(3.0/2);
//        System.out.println(3.0/2.00);

//        Main main = new Main();
//
//        Set<String> list = new HashSet<>();
//        list.add(null);
//        list.add(null);
//        list.add("123");
//        list.add("123");
//        list.add("234");
////
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String str = it.next();
//            System.out.println(str);
//        }
//
//
//
//        System.out.println(list.size());
//
//        String path = "https://passport.58.com/thd/proxylogin/m/weixin?path=http%253A%252F%252Ftestbaoxian.58.com%252Fproduct%252Findex%2523%252Fapply%252FapplicantInfo%252F58sjbzhywx_0001%252F58&source=baoxian-wechat&tokenCode=g6OBmZYWxPWA-vNraO7i5ZWxv_pWXk4W";
//        String path1 = "https://passport.58.com/thd/proxylogin/m/weixin?path=https%253A%252F%252Fbaoxian.58.com%252Fproduct%252Findex%2523%252Fapply%252Findex&source=baoxian-wechat&tokenCode=oUfQ6AwWpZ5BP21GJcCR4aGqCbfOPw87";
//
//            String result = URLDecoder.decode(path);
//            System.out.println("############");
//            System.out.println(URLDecoder.decode(result));
//
//            String result1 = URLDecoder.decode(path1);
//            System.out.println(URLDecoder.decode(result1));



//        List<String> list1 = new LinkedList<>();
//        list1.add("A");
//        list1.add("B");
//        list1.add("C");
//        list1.add("D");
//
//        List<String> list2 = new LinkedList<String>();
//        list2.add("A");
//        list2.add("A");
//        list2.add("A");
//        list2.add("B");
//        list2.add("B");
//        list2.add("C");
        // 并集
//        list1.addAll(list2);
        // 去重复并集
//        list2.removeAll(list1);
//        list1.addAll(list2);
        // 交集
//        list1.retainAll(list2);
        // 差集
//        list1.removeAll(list2);
//        List<String> result = (List<String>)CollectionUtils.subtract(list1,list2);
//        List<String> result2 = (List<String>)CollectionUtils.subtract(list2,list1);
//
//        System.out.println();
//
//
//
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//
//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }
//
//        System.out.println(list);

//        String url = "http://testbaoxian.58.com/product/goToPartnerOrProductDetail/yhkdsx?channel=58jz&sign=c9JzibMIxvv7F1VClL9hJyATIDdTztANqcPynrFIlJ3H%2FQLlJJKBjF5Lrcx9XCG970WXXnlykGR3%0A%2FsnXB5%2FdAQ%3D%3D";

//        String s1 = "hello";
//        String s2 = "hello";
//        System.out.println(s1==s2);

//        String value = System.getProperty("rpc_dict_findByPath");
//        System.out.println(value);

//        Properties properties = System.getProperties();
//        Set<String> propertyNames = properties.stringPropertyNames();
//        Iterator<String> iterator = propertyNames.iterator();
//        while(iterator.hasNext()){
//            String key = iterator.next();
//            String value = (String) properties.get(key);
//            System.out.println("key="+key+"#######value="+value);
//        }


//        ClassLoader classLoader = Main.class.getClassLoader();
//        System.out.println("#######classLoader:"+classLoader.toString());

//        System.out.println(Object.class.getClassLoader().toString());
//        System.out.println(String.class.getClassLoader().toString());
//        System.out.println(Double.class.getClassLoader().toString());
//        System.out.println(Date.class.getClassLoader().toString());
//
//        PageTool<String> pageTool = new PageTool<>();
//        pageTool.setRecords(Arrays.asList("1","2","3","4"));
//
////        System.out.println(PageTool.class.getName());
//        ClassPool pool = ClassPool.getDefault();
//        try {
//            CtClass ctClass = pool.get(PageTool.class.getName());
//            CtMethod[] ctMethods = ctClass.getMethods();
//            for (CtMethod ctMethod:ctMethods
//                 ) {
//                System.out.printf("method:%s\n",ctMethod.getName());
//            }
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        testA(pageTool);

//        LocalDateTime localDateTime = LocalDateTime.now();
//        localDateTime = localDateTime.plusDays(1);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        String dateStr = formatter.format(localDateTime);
//        System.out.printf("dateStr:%s\n",dateStr);

//        System.out.printf("Long.Max:%d\n",Long.MAX_VALUE);

//        Long id = null;
//        Long test = 123L;
//        boolean idFlag = Optional.ofNullable(id).isPresent();
//        boolean testFlag = Optional.ofNullable(test).isPresent();
//        System.out.printf("idFlag:%s,testFlag:%s",idFlag,testFlag);

//        List input = new ArrayList<>();
//        List<Map> list = new ArrayList<>(input);
//        list.addAll(map)
//        int size = 22;
//        int result = size >> 1;
//        System.out.printf("result:%d",result);
//
//        Queue<String> list = new LinkedList<>();
//        list.add("1");
//        list.add("2");
//
//        list.offer("3");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        list.remove(2);

//        for(String str : list){
//            list.remove(str);
//        }


////        int a;
//        int b = 1;
//        Object[] array = list.toArray();
//        System.out.printf("first:%s,last:%s\n",list.getFirst(),list.getLast());
//        System.out.printf("peekFirst:%s,peekLast:%s\n",list.peekFirst(),list.peekLast());
//        System.out.printf("peek:%s\n",list.element());
//        System.out.printf("peek:%s\n",list.peek());
//        System.out.printf("peek:%s\n",list.poll());
//        Long claimRecordId = 12L;
//        boolean result = Optional.ofNullable(claimRecordId).isPresent();
//        System.out.println("result:"+result);


//        CollectionUtils.subtract()
//        System.out.printf("a:%d",Integer.MAX_VALUE);
//
////        list.add("1");
//        String[] a = {"1","2","3"};
//
//        String[] b = Arrays.copyOf(a, 6);
//        for(String str : b){
//            System.out.printf("str:%s\n\n",str);
//        }
//
//        System.out.printf("b.size:%d\n",b.length);
//
//        String[] c = {"1","2","3","5"};
//        String[] dest = new String[10];
//        System.arraycopy(c,0,dest,0,4);
//        for(String str : dest){
//            System.out.printf("dest.str:%s,",str);
//        }


    }
}
