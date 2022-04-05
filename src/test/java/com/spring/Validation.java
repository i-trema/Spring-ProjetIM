package com.spring;

import java.util.List;

public class Validation {

public boolean notNull(Object object) {
	return (object != null); 
}

public boolean listNotEmpty(List list) {
	return !(list.isEmpty());
}

public boolean entierConvertible(String a) {
	try {
		Integer.parseInt(a);
		return true;
	}
	catch(Exception ex) {
		return false;
	}
}
public boolean doubleConvertible(String a) {
	try {
		Double.parseDouble(a);
		return true;
	}
	catch(Exception ex) {
		return false;
	}
}

public boolean stringNotEmpty(String string) {
	return !(string.isEmpty());
}

public boolean passwordWithoutName(String password, String nom) {
	return !password.contains(nom);
}

public boolean nomOneSpace(String nomComplet) {
	return !nomComplet.contains(" ");
}
}
