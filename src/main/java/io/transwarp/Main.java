package io.transwarp;

/**
 * Created by qls on 18-10-22.
 */
public class Main {

    private static HdfsClient hdfsClient;

    public static void main(String[] args) throws Exception {

        hdfsClient = new HdfsClient();
        System.out.println("INFO init hdfsClinet SUCCESS");
        String dir = "/tmp/xxx";
        System.out.println("[INFO] begin exec: hdfs dfs -mkdir -p " + dir);
        hdfsClient.mkdirDir(dir);
        System.out.println("[INFO] begin exec: hdfs dfs -mkdir -p " + dir + " SUCCESS");

    }


}
