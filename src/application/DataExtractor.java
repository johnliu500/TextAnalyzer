package application;

import java.util.*;
import java.lang.Math;

public class DataExtractor {
	private ArrayList<Map.Entry<String, Integer>> sorted;

	public DataExtractor(String data) {
		String[] wordsSplit = data.split(" ");
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		
		for (int i=0; i<wordsSplit.length; i++) {
			if (map.containsKey(wordsSplit[i].toLowerCase()))
				map.put(wordsSplit[i].toLowerCase(), map.remove(wordsSplit[i])+1);
			else map.put(wordsSplit[i].toLowerCase(), 1);
		}

		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		sorted = new ArrayList<>();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)it.next();
			System.out.println(pair.getKey()+", "+pair.getValue());
			sorted.add(pair);
		}
		System.out.println(quickSort(sorted));
	}

	private ArrayList<Map.Entry<String, Integer>> quickSort(ArrayList<Map.Entry<String, Integer>> counts){
		if (counts.size()<=1)
			return counts;
		ArrayList<Map.Entry<String, Integer>> left = new ArrayList<Map.Entry<String, Integer>>();
		ArrayList<Map.Entry<String, Integer>> right = new ArrayList<Map.Entry<String, Integer>>();

		int pivot =  (int) (Math.random() * counts.size());

		for (int i=0; i<counts.size(); i++){
			if (i!=pivot){
				if (counts.get(i).getValue()>counts.get(pivot).getValue())
					left.add(counts.get(i));
				else
					right.add(counts.get(i));
			}

		}
		left = quickSort(left);
		right = quickSort(right);

		left.add(counts.get(pivot));
		left.addAll(right);
		return left;
	}

	public ArrayList<String> getTopFive(){
		ArrayList<String> topFive = new ArrayList<String>();
		int max = Math.min(5, sorted.size());
		for (int i=0; i<max;i++){
			topFive.add(sorted.get(i).getKey());
		}
		return topFive;
	}
	
	public int wordCount(){
		int count = 0;
		for (int i=0; i<sorted.size(); i++) {
			count += sorted.get(i).getValue();
		}
		return count;
	}

	public int numSentences(){
		return sorted.size();//not yet finished
	}

	public int averageWordsPerSentences(){
		return sorted.size();//not yet finished
	}

	public void printAllData(){
		ArrayList<String> topFive= getTopFive();
		System.out.println("Top " + topFive.size() + " words are: " + getTopFive());
	}
}
