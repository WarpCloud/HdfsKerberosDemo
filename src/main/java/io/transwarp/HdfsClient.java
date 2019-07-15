package io.transwarp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;

/**
 * Created by qls on 18-10-24.
 */
public class HdfsClient {

    private FileSystem fileSystem;
    private Configuration conf = new Configuration();

    private static String DEFAULT_HDFS_KEYTAB_FILE = Constants.DEFAULT_HDFS_KEYTAB_FILE;
    private static String DEFAULT_HDFS_SITE_FILE = Constants.DEFAULT_HDFS_SITE_FILE;
    private static String DEFAULT_HDFS_CORE_SITE_FILE = Constants.DEFAULT_HDFS_CORE_SITE_FILE;
    private static String HDFS_KERBEROS_PRINCIPAL = Constants.HDFS_KERBEROS_PRINCIPAL;

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public HdfsClient() throws Exception {

        conf.addResource(new Path(DEFAULT_HDFS_SITE_FILE));
        conf.addResource(new Path(DEFAULT_HDFS_CORE_SITE_FILE));
        conf.set("hadoop.security.authentication", "kerberos");
        initKerberos();

        this.fileSystem = FileSystem.get(conf);

    }

    private void initKerberos() throws  Exception{

        String principal = HDFS_KERBEROS_PRINCIPAL;
        System.out.println("===== HDFS_KERBEROS_PRINCIPAL: " + principal);
        System.out.println("===== DEFAULT_HDFS_KEYTAB_FILE: " + DEFAULT_HDFS_KEYTAB_FILE);
        if( principal == null || principal.length() <= 0 ){
           System.out.println("cannot get principal");
           throw new Exception("principal is null ");
        }
        System.out.println("Kerberos enabled, use principal: " + principal);
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab(principal, DEFAULT_HDFS_KEYTAB_FILE);

    }


    public void mkdirDir(String dir) throws IOException {

        if (!fileSystem.exists(new Path(dir))) {

            fileSystem.mkdirs(new Path(dir));

        }

    }

}
