package com.memory.usage;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.openjdk.jol.info.GraphLayout;

public class CountSingleWord {
		
public static void main(String args[]) throws IOException 
{
int allocationValue=1024;	
Path path=Paths.get(new File("").getAbsolutePath()+File.separator+"testFiles","SingleWordCount.txt");
SeekableByteChannel sbc=Files.newByteChannel(path, StandardOpenOption.READ);
ByteBuffer bf=ByteBuffer.allocate(allocationValue);
BigInteger CountWord=new BigInteger("0");
BigInteger incrementValue=BigInteger.ONE;

int i;
while((i=sbc.read(bf))>0){
bf.flip();
for(int k=0; k<bf.limit();k++)
{
if((char)bf.get()=='a'){
CountWord=CountWord.add(incrementValue);
}
}
bf.clear();
}
System.out.println("Word 'a' occurence :"+CountWord);
//System.out.println("Bytes used by BinaryInteger..."+InstrumentationAgent.getObjectSize(CountWord));
}

}
