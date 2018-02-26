package org.study.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Future模式
 * @author ArnoldLee
 * @date 18/2/12
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long beginTime = System.currentTimeMillis();
        Callable<MatchApplyVo> matchApplyVoCallable = new Callable<MatchApplyVo>() {
            @Override
            public MatchApplyVo call() throws Exception {
                MatchApplyVo applyVo = new MatchApplyVo();
                applyVo.setPkid(1L);
                applyVo.setName("出资申请");
                applyVo.setType("0");//出资申请
                System.out.println("组装成待匹配的出资申请");
                return applyVo;
            }
        };


        FutureTask<MatchApplyVo> task = new FutureTask<MatchApplyVo>(matchApplyVoCallable);
        new Thread(task).start();

        Thread.sleep(500);

        while(task.isDone()){
            System.out.println("组装待匹配申请,完成!");
            MatchApplyVo matchApplyVo = task.get();
            System.out.println("查询待匹配流水....");
            break;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("耗时:"+(endTime-beginTime)+"ms");



    }

    private static class MatchApplyVo {
        private String name;
        private String type;
        private Long pkid;

        public MatchApplyVo() {
        }

        public MatchApplyVo(String name, String type, Long pkid) {
            this.name = name;
            this.type = type;
            this.pkid = pkid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getPkid() {
            return pkid;
        }

        public void setPkid(Long pkid) {
            this.pkid = pkid;
        }
    }
}
