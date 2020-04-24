package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SerializationBreakSingleton {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		SingletonEx instance1 = SingletonEx.createObj();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("test.txt"));
		out.writeObject(instance1);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("test.txt"));
		SingletonEx instance2 = (SingletonEx) in.readObject();
		in.close();
		
		if(instance1 == instance2) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
