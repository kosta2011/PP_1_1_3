package jm.task.core.jdbc.GenerateRandomUser;

public class GenerateUser {

    public static String getName() {
        String[] names = {"Michael", "James", "Matthew", "Nicholas",
                "Christopher", "Joseph", "Zachary", "Joshua", "Andrew",
                "William", "Daniel", "Christian", "Tyler", "Ryan", "Anthony",
                "Alexander", "Jonathan", "David", "Dylan", "Jacob", "Emily",
                "Hannah", "Kaitlyn", "Sarah", "Madison", "Brianna",
                "Kaylee", "Hailey", "Alexis", "Elizabeth", "Taylor",
                "Lauren", "Ashley", "Katherine", "Jessica", "Anna", "Samantha",
                "Alissa", "Kayla", "Madeline"
        };
        while (true) {
            byte rnd = (byte) (Math.random() * 100);
            if (rnd < names.length) return names[rnd];
        }
    }

    public static String getLastName() {
        String[] lastNames = {"Adamson","Arthurs","Backer","Birch","Brown",
                "Campbell","Carter","Clifford","Daniels","Dutton",
                "Edwards","Enderson","Farmer","Forster","Freeman",
                "Goldman","Holiday","Jeff","Kennedy","Larkins",
                "Longman","Macey","Marlow","Miller","Neal",
                "Oldman","Palmer","Simpson","Stevenson",
                "Walter","Winter","Young"
        };

        while (true) {
            byte rnd = (byte) (Math.random() * 100);
            if (rnd < lastNames.length) return lastNames[rnd];
        }
    }

    public static byte getAge() {
        while (true) {
            byte rnd = (byte) (Math.random() * 100);
            if (rnd > 10 && rnd < 55) return rnd;
        }
    }
}
