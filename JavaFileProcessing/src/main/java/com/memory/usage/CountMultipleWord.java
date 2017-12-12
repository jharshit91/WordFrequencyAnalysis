package com.memory.usage;



import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

import org.openjdk.jol.info.GraphLayout;

public class CountMultipleWord {
	
	
public static void main(String args[]) throws IOException 
{
	Path path=Paths.get(new File("").getAbsolutePath()+File.separator+"testFiles","MultipleWordCount.txt");
	BigInteger BaseValue = BigInteger.ONE;
	Map<String, BigInteger> map = new HashMap<>();
	try (Stream<String> s = Files.lines(path)) {
		s.forEach(name -> {
			if(!name.equals("")){
			if (map.get(name) != null) {
				BigInteger currentValue = map.get(name);
				map.put(name, currentValue.add(BaseValue));
			} else {
				map.put(name, BaseValue);
			}
		}});

	}
	System.out.println("Map are "+map.toString());
	 System.out.println(GraphLayout.parseInstance(map).toFootprint());

}

}





