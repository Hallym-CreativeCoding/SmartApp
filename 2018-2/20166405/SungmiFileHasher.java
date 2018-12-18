package com.sungmi.sungmiHasher;


//Import//


import android.content.Context;      
import android.util.Log;  
//import android.app.Activity;
//import android.os.Environment;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.collect.Sets;
import com.google.appinventor.components.runtime.util.BoundingBox;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.PaintUtil;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;


//Component description//

@DesignerComponent(version = YaVersion.SUNGMI_TEST_VERSION,                           
    description = "my testings",                                                       
    category = ComponentCategory.EXTENSION,                            
    nonVisible = true,                                                               
    iconName = "images/web.png")                                             

@SimpleObject(external = true)    
@UsesLibraries(libraries = "org-apache-commons-codec.jar") 
@UsesPermissions(permissionNames = "android.permission.WRITE_EXTERNAL_STORAGE, android.permission.READ_EXTERNAL_STORAGE")


public class SungmiFileHasher extends AndroidNonvisibleComponent    //Has to be same as the java file name
implements Component {     

    public static final int VERSION = 0; 	
    private ComponentContainer container;                               
    private Context context;                                                            
    private static final String LOG_TAG = "sungmi EXTENSION STARTS!!!!";                      
	private DigestUtils DigestUtils;
	private Hex Hex;
	private DecoderException DecoderException;
	//private final Activity activity;
	//private boolean isRepl = false;

   
   public SungmiFileHasher (ComponentContainer container) {         
        super(container.$form());                                
        this.container = container;                              
        context = (Context) container.$context();                      //copied         
        Log.d(LOG_TAG, "sungmiHasher created" );                                 //log msg
    }

 
 @SimpleFunction(description = "reads file as binary and hashes with md5")
 
 public String SungmiMD5(String fileName) {
	String md5String = null;
	
	//String md5String = null;
	 try {
		 //md5String = DigestUtils.md5Hex(new FileInputStream(fileName));
		 md5String = new String(Hex.encodeHex(DigestUtils.md5(new FileInputStream(fileName))));

		 //String s = new String(Hex.encodeHex(DigestUtils.md5(data)));
	 } catch (IOException e){
		 Log.d(LOG_TAG, "IO exception");
	 }
	 Log.d(LOG_TAG, "md5String");
	 return md5String;	
	
}



 @SimpleFunction(description = "reads file as binary and hashes with sha256")
 
 public String SungmiSHA256(String fileName) {
	String sha256String = null;
	
	//String md5String = null;
	 try {
		 //md5String = DigestUtils.md5Hex(new FileInputStream(fileName));
		 sha256String = new String(Hex.encodeHex(DigestUtils.sha256(new FileInputStream(fileName))));

		 //String s = new String(Hex.encodeHex(DigestUtils.md5(data)));
	 } catch (IOException e){
		 Log.d(LOG_TAG, "IO exception");
	 }
	 Log.d(LOG_TAG, "md5String");
	 return sha256String;	
	
}


}