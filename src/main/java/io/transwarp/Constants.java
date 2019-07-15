package io.transwarp;

/**
 * Created by qls on 18-10-26.
 */
public class Constants {

    //hdfs
    static String HDFS_KERBEROS_PRINCIPAL = System.getenv("HDFS_KERBEROS_PRINCIPAL");
    static String DEFAULT_HDFS_KEYTAB_FILE = "/etc/keytabs/keytab";
    static String DEFAULT_HDFS_SITE_FILE = "/etc/hadoop/conf/hdfs-site.xml";
    static String DEFAULT_HDFS_CORE_SITE_FILE = "/etc/hadoop/conf/core-site.xml";

}
