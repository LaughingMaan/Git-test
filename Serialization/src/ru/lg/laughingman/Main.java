package ru.lg.laughingman;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import by.zti.SerializationManager;

/*private static void serData(String file_name, Object obj) {
try {
	FileOutputStream fileOut = new FileOutputStream(file_name + ".ser");
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(obj);
	fileOut.close();
	out.close();

} catch (FileNotFoundException ex) {
	System.out.println("File not found!");
	System.exit(1);
} catch (IOException ex) {
	System.out.println("I/O error");
	System.exit(2);
}

}

private static Object deserData(String file_name) {
Object retObject = null;
try {
	FileInputStream fileIn = new FileInputStream(file_name + ".ser");
	ObjectInputStream in = new ObjectInputStream(fileIn);
	retObject = in.readObject();
	fileIn.close();
	in.close();
} catch (FileNotFoundException ex) {
	System.out.println("File not found!");
	System.exit(1);
} catch (IOException ex) {
	System.out.println("I/O error");
	System.exit(2);
} catch (ClassNotFoundException e) {
	System.out.println("Class not found");
	System.exit(3);
}
return retObject;
}*/

public class Main {
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		profiles = (ArrayList<Profile>) SerializationManager.deSerializeData("Profiles", "ser", "");
		System.out.println(profiles.size());
		Profile profile = new Profile();
		profile.setName(JOptionPane.showInputDialog(null, "Put your name"));
		profile.setSurname(JOptionPane.showInputDialog(null, "Put your surname"));
		profiles.add(profile);
		for (Profile p : profiles) {
			System.out.println(p.getName() + " " + p.getSurname());
		}
		System.out.println(profiles.size());
		SerializationManager.serializeData(profiles, "Profiles", "ser", "");
	}
}
