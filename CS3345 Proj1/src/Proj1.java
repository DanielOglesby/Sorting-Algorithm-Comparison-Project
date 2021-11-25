import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Timer;

public class Proj1 extends JFrame implements ActionListener, MouseListener, ChangeListener {
	
	//GUI components
	JPanel myPanel;
	JSlider nSlider;
	JButton inOrder, reverseOrder, almostOrder, random;
	JButton insertionSort, selectionSort, quickSort, mergeSort, radixSort, heapSort;
	JButton createList;
	JLabel label1;
	JTextPane n, dataTypePane, sort, comparisons, movements, totalTime, winningAlgo;
    int value;
    int size;
    int moreSort;
    int sortValue;
    String dataType;
    
    //variables to track comparisons and moves of each sort
    static int comp = 0;
    static int moves = 0;
    static int time = 0;
    
    //timer variables
    long startTime;
    long endTime;
    static long bestTime;
    long currentTime;
    long insertionTime, selectionTime, quickTime, mergeTime, radixTime, heapTime;
    
	public Proj1(){
		//initialize panel
		myPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = gc.BOTH;
		gc.weightx = 1;
		gc.weighty = 0;
		
		
		//instantiate objects for panel
		n = new JTextPane();
		dataTypePane = new JTextPane();
		sort = new JTextPane();
		comparisons = new JTextPane();
		movements = new JTextPane();
		totalTime = new JTextPane();
		winningAlgo = new JTextPane();
		nSlider = new JSlider(JSlider.HORIZONTAL, 1000, 50000, 1000);
		nSlider.setMajorTickSpacing(7500);
		nSlider.setPaintTicks(true);
		nSlider.setPaintLabels(true); 
		
		
		//initialize buttons
		createList = new JButton("Create The List");
		inOrder = new JButton("In Order");
		reverseOrder = new JButton("Reverse Order");
		almostOrder = new JButton("Almost Order");
		random = new JButton("Random");
		insertionSort = new JButton("Insertion Sort");
		selectionSort = new JButton("Selection Sort");
		quickSort = new JButton("Quick Sort");
		mergeSort = new JButton("Merge Sort");
		radixSort = new JButton("Radix Sort");
		heapSort = new JButton("Heap Sort");
		
		//text panes uneditable
		dataTypePane.setEditable(false);
		sort.setEditable(false);
		comparisons.setEditable(false);
		movements.setEditable(false);
		totalTime.setEditable(false);
		winningAlgo.setEditable(false);
		n.setEditable(false);
		
		
		//place stuff on panel
		gc.gridx = 0; 
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		myPanel.add(inOrder, gc);
		gc.gridy = 1;
		myPanel.add(reverseOrder, gc);
		gc.gridy = 2;
		myPanel.add(almostOrder, gc);
		gc.gridy = 3;
		myPanel.add(random, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		myPanel.add(insertionSort, gc);
		gc.gridy = 1;
		myPanel.add(selectionSort, gc);
		gc.gridy = 2;
		myPanel.add(quickSort, gc);
		gc.gridy = 3; 
		myPanel.add(mergeSort, gc);
		gc.gridy = 4;
		myPanel.add(radixSort, gc);
		gc.gridy = 5;
		myPanel.add(heapSort,gc);
		gc.gridx = 2;
		gc.gridy = 0;
		myPanel.add(n, gc);
		gc.gridy = 1;
		myPanel.add(dataTypePane, gc);
		gc.gridy = 2;
		myPanel.add(sort, gc);
		gc.gridy = 3;
		myPanel.add(comparisons, gc);
		gc.gridy = 4;
		myPanel.add(movements, gc);
		gc.gridy = 5;
		myPanel.add(totalTime, gc);
		gc.gridy = 6;
		myPanel.add(winningAlgo, gc);
		gc.gridx = 3;
		gc.gridy = 0;
		myPanel.add(createList, gc);
		gc.gridy = 1;
		myPanel.add(nSlider, gc);
		add(myPanel, BorderLayout.CENTER);
		
		//add action & mouse listeners to buttons & sliders
		inOrder.addActionListener(this);
		reverseOrder.addActionListener(this);
		almostOrder.addActionListener(this);
		random.addActionListener(this);
		insertionSort.addActionListener(this);
		selectionSort.addActionListener(this);
		mergeSort.addActionListener(this);
		quickSort.addActionListener(this);
		radixSort.addActionListener(this);
		heapSort.addActionListener(this);
		createList.addActionListener(this);
		createList.addMouseListener(this);
		insertionSort.addMouseListener(this);
		selectionSort.addMouseListener(this);
		mergeSort.addMouseListener(this);
		quickSort.addMouseListener(this);
		radixSort.addMouseListener(this);
		heapSort.addMouseListener(this);
		inOrder.addMouseListener(this);
		reverseOrder.addMouseListener(this);
		almostOrder.addMouseListener(this);
		random.addMouseListener(this);
		nSlider.addChangeListener(this);
		
	}
	
	//slider listener
	public void stateChanged(ChangeEvent e) {
		size = nSlider.getValue();
		n.setText("n: "+size);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	//mouse press listener
	public void mousePressed(MouseEvent e) {
	if(e.getSource() == inOrder) {
		dataTypePane.setText("inOrder");
		value = 1;
		}
	if (e.getSource() == reverseOrder) {
		dataTypePane.setText("Reverse Order");
		value = 2;
	}
	if (e.getSource() == almostOrder) {
		dataTypePane.setText("Almost Order");
		value = 3;
	}
	if (e.getSource() == random) {
		dataTypePane.setText("Random");
		value = 4;
	}
	if (e.getSource() == insertionSort) {
		sort.setText("Insertion Sort");
		sortValue = 1;
	}
	if (e.getSource() == selectionSort) {
		sort.setText("Selection Sort");
		sortValue = 2;
	}
	if (e.getSource() == quickSort) {
		sort.setText("Quick Sort");
		sortValue = 3;
	}
	if (e.getSource() == radixSort) {
		sort.setText("Radix Sort");
		sortValue = 6;
	}
	if (e.getSource() == heapSort) {
		sort.setText("Heap Sort");
		sortValue = 5;
	}
	if(e.getSource() == mergeSort) {
		sort.setText("Merge Sort");
		sortValue = 4;
	}
	if(e.getSource() == createList) {
		// re initialize output variables
		  comp = 0;
		  moves = 0;
		  time = 0;
		  
	      int[] array = new int[size];
	      if(value == 4) {
	      for(int i = 0; i < array.length; i++) {
	    	  array[i] = (int)(Math.random()*size);
	      }
	     }
	      else if(value == 3) {
	    	  int count = 0;
	    	  for(int i = 0; i < array.length; i++) {
	    		  count = count + ((int)(Math.random()*10));
	    		  if(count % 3 != 0) {
	    			  array[i] = count;
	    		  }
	    		  else {
	    			  count = count - ((int)(Math.random()*10));
	    			  array[i] = count;
	    		  }
	    			  
	    	  }
	      }
	      else if(value == 2) {
	    	  int count = 0;
	    	  for(int i = array.length-1; i >= 0; i--) {
	    		  count = count + ((int)(Math.random()*10));
	    		  array[i] = count;
	    	  }
	      }
	      else if(value == 1) {
	    	  int count = 0;
	    	  for(int i = 0; i < array.length; i++) {
	    		  count = count + ((int)(Math.random()*10));
	    		  array[i] = count;
	    	  } 
	      }
	      printArray(array);
	      
	      if(sortValue == 1) {
	    	  startTime = System.currentTimeMillis();
	    	  insertionSort(array);
	    	  endTime = System.currentTimeMillis();
	    	  insertionTime = (endTime - startTime);
	      }
	      else if(sortValue == 2) {
	    	  startTime = System.currentTimeMillis();
	    	  selectionSort(array);
	    	  endTime = System.currentTimeMillis();
	    	  selectionTime = (endTime - startTime);
	      }
	      else if(sortValue == 3) {
	    	  startTime = System.currentTimeMillis();
	    	  quickSort(array, 0, array.length-1);
	    	  endTime = System.currentTimeMillis();
	    	  quickTime = (endTime - startTime);
	      }
	      else if(sortValue == 4) {
	    	  startTime = System.currentTimeMillis();
	    	  mergeSort(array, array.length);
	    	  endTime = System.currentTimeMillis();
	    	  mergeTime = (endTime - startTime);
	      }
	      else if(sortValue == 5) {
	    	  startTime = System.currentTimeMillis();
	    	  heapSort(array);
	    	  endTime = System.currentTimeMillis();
	    	  heapTime = (endTime - startTime);
	      }
	      else if(sortValue == 6) {
	    	  startTime = System.currentTimeMillis();
	    	  radixSort(array, array.length);
	    	  endTime = System.currentTimeMillis();
	    	  radixTime = (endTime - startTime);
	      }
	      
	      printArray(array);
	      
	      comparisons.setText("Comparisons: "+comp);
	      movements.setText("Moves: " + moves);
	      winningAlgo.setText("Winning Algorithm: " + compareTime());
	      totalTime.setText("Total Time: " + (endTime-startTime) + "ms");
	      
	      
	}
	
	}
	
	//find which sorting algorithm is fastest in terms of time and return string for output
	public String compareTime() {
		int position = 0;
		long[] timeArray = {insertionTime, selectionTime, quickTime, mergeTime, heapTime, radixTime};
		for(int i = 0; i < 4; i++) {
			if(timeArray[i] < timeArray[i+1]);
				position = i;
		}
		
		if(position == 0)
			return "Insertion Sort";
		else if(position == 1)
			return "Selection Sort";
		else if(position == 2)
			return "Quick Sort";
		else if(position == 3)
			return "Merge Sort";
		else if(position == 4)
			return "Heap Sort";
		else if(position == 5)
			return "Radix Sort";
		else
			return "ERROR";
	}
	
	public void mouseEntered (MouseEvent e) {
		
	}
	public void mouseExited (MouseEvent e) {
		
	}
	public void mouseReleased (MouseEvent e) {

	}
	public void mouseClicked (MouseEvent e) {
		
	}
	
  public static void main(String [] args) {
	//instantiate window
	Proj1 newWindow = new Proj1();
	newWindow.setTitle("Asymptotic Analysis");
	newWindow.setSize(1000, 1000);
	newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	newWindow.setVisible(true);
	newWindow.setResizable(true);
	//used this code to figure out if my algorithms were working or not... commenting out as not part of GUI based project
    /*Scanner input = new Scanner(System.in);
    int value;
    int size;
    int moreSort;
    int sortValue;

    do {
      System.out.print("Select the type of list (enter a value)\n");
      System.out.print("1. InOrder\n2. ReverseOrder\n3. AlmostOrder\n4. Random\n");
      System.out.print("Enter Data Type: ");
      value = input.nextInt();
      //System.out.printf("Value: %d\n", value);
      System.out.print("Enter the size of the list (1000-50000): ");
      // add validation later
      size = input.nextInt();
      
      //create array
      int[] array = new int[size];
      if(value == 4) {
      for(int i = 0; i < array.length; i++) {
    	  array[i] = (int)(Math.random()*size);
      }
     }
      else if(value == 3) {
    	  
      }
      else if(value == 2) {
    	  int count = 0;
    	  for(int i = array.length-1; i >= 0; i--) {
    		  count = count + ((int)(Math.random()*10));
    		  array[i] = count;
    	  }
      }
      else if(value == 1) {
    	  int count = 0;
    	  for(int i = 0; i < array.length; i++) {
    		  count = count + ((int)(Math.random()*10));
    		  array[i] = count;
    	  } 
      }
      
      
      printArray(array);

      System.out.print("Select the type of list (enter a value)\n");
      System.out.print("1. Insertion Sort\n2. Selection Sort\n3. Quick Sort\n4. Merge Sort\n5. Heap Sort\n6. Radix Sort\n");
      System.out.print("Enter Sort Type: ");
      sortValue = input.nextInt();
      
      // at the end
      if(sortValue == 1) {
    	  insertionSort(array);
      }
      else if(sortValue == 2) {
    	  selectionSort(array);
      }
      else if(sortValue == 3) {
    	  quickSort(array, 0, array.length-1);
      }
      else if(sortValue == 4) {
    	  mergeSort(array, array.length);
      }
      else if(sortValue == 5) {
    	  heapSort(array);
      }
      else if(sortValue == 6) {
    	  radixSort(array, array.length);
      }
      
      printArray(array);

      String dataType;
      if (value == 1) dataType = "InOrder";
      else if (value == 2) dataType = "ReverseOrder";
      else if (value == 3) dataType = "AlmostOrder";
      else dataType = "Random";

      String sortType;
      if (sortValue == 1) sortType = "Insertion Sort";
      else if (sortValue == 2) sortType = "Selection Sort";
      else if (sortValue == 3) sortType = "Quick Sort";
      else if (sortValue == 4) sortType = "Merge Sort";
      else if (sortValue == 5) sortType = "Heap Sort";
      else sortType = "Radix Sort";

      System.out.println("Experimental Results");
      System.out.printf("N: %d\n", size);
      System.out.printf("DataType: %s\n", dataType);
      System.out.printf("Sort: %s\n", sortType);
      System.out.printf("Comparisons: %d\n", comp);
      System.out.printf("Movements: %d\n", moves);
      System.out.printf("Total time: %d\n", time);
      System.out.println(comp + " comparisons");
      System.out.println(moves + " swaps");
      System.out.println(time + " time");
      
      System.out.print("Do you wish to continue? <Enter 1 to continue or 0 to Stop> ");
      moreSort = input.nextInt();
    } while (moreSort != 0);*/
  }
  
  //insertion sort
  public static void insertionSort(int arr[]) 
  { 
      int n = arr.length; 
      for (int i = 1; i < n; ++i) { 
    	  comp++;
          int key = arr[i]; 
          int j = i - 1; 
          /* Move elements of arr[0..i-1], that are 
             greater than key, to one position ahead 
             of their current position */
          while (j >= 0 && arr[j] > key) { 
        	  comp++;
              arr[j + 1] = arr[j]; 
              j = j - 1; 
          } 
    	  moves++;
          arr[j + 1] = key; 
      } 
  }
  
  //selection sort
  public static void selectionSort(int[] arr){  
      for (int i = 0; i < arr.length - 1; i++)  
      {  
          int index = i;  
          for (int j = i + 1; j < arr.length; j++){  
        	  comp++;
              if (arr[j] < arr[index]){  
                  index = j;//searching for lowest index  
              }  
          }  
          moves++;
          int smallerNumber = arr[index];   
          arr[index] = arr[i];  
          arr[i] = smallerNumber;
      }  
  }  
  
  public static int partition(int arr[], int low, int high) 
  { 
      int pivot = arr[high];  
      int i = (low-1); // index of smaller element 
      for (int j=low; j<high; j++) 
      { 
          comp++;
          // If current element is smaller than the pivot 
          if (arr[j] < pivot) 
          { 
              i++; 

              // swap arr[i] and arr[j] 
              moves++;
              int temp = arr[i]; 
              arr[i] = arr[j]; 
              arr[j] = temp; 
          } 
      } 

      // swap arr[i+1] and arr[high] (or pivot) 
      //moves++;
      int temp = arr[i+1]; 
      arr[i+1] = arr[high]; 
      arr[high] = temp; 

      return i+1; 
  } 
  
  //quicksort
  public static void quickSort(int arr[], int low, int high) 
  { 
      if (low < high) 
      { 
          /* pi is partitioning index, arr[pi] is  
            now at right place */
          int pi = partition(arr, low, high); 

          // Recursively sort elements before 
          // partition and after partition 
          quickSort(arr, low, pi-1); 
          quickSort(arr, pi+1, high); 
      } 
  } 
  
  //heapsort
  public static void heapSort(int arr[]) 
  { 
      int n = arr.length; 

      // Build heap (rearrange array) 
      for (int i = n / 2 - 1; i >= 0; i--) 
          heapify(arr, n, i); 

      // One by one extract an element from heap 
      for (int i=n-1; i>0; i--) 
      { 
          // Move current root to end 
    	  moves++;
          int temp = arr[0]; 
          arr[0] = arr[i]; 
          arr[i] = temp; 

          // call max heapify on the reduced heap 
          heapify(arr, i, 0); 
      } 
  } 

  // To heapify a subtree rooted with node i which is 
  // an index in arr[]. n is size of heap 
  static void heapify(int arr[], int n, int i) 
  { 
      int largest = i; // Initialize largest as root 
      int l = 2*i + 1; // left = 2*i + 1 
      int r = 2*i + 2; // right = 2*i + 2 
      
      // If left child is larger than root 
      if (l < n && arr[l] > arr[largest]) {
          largest = l; 
      	  comp++;
      }
      // If right child is larger than largest so far 
      if (r < n && arr[r] > arr[largest]) {
          largest = r; 
         comp++;
      }
      // If largest is not root 
      if (largest != i) 
      { 
    	  moves++;
          int swap = arr[i]; 
          arr[i] = arr[largest]; 
          arr[largest] = swap; 

          // Recursively heapify the affected sub-tree 
          heapify(arr, n, largest); 
      } 
  } 
  
  //merge sort
  public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	}
  
  public static void merge(
		  int[] a, int[] l, int[] r, int left, int right) {
		 
		    int i = 0, j = 0, k = 0;
		    while (i < left && j < right) {
		    	comp++;
		        if (l[i] <= r[j]) {
		            a[k++] = l[i++];
		        }
		        else {
		            a[k++] = r[j++];
		        }
		    }
		    while (i < left) {
		    	comp++;
		        a[k++] = l[i++];
		    }
		    while (j < right) {
		    	comp++;
		        a[k++] = r[j++];
		    }
		}
  
  //radix sort
  static void radixSort(int arr[], int n) 
  { 
      // Find the maximum number to know number of digits 
      int m = getMax(arr, n); 

      // Do counting sort for every digit. Note that instead 
      // of passing digit number, exp is passed. exp is 10^i 
      // where i is current digit number 
      for (int exp = 1; m/exp > 0; exp *= 10)
          countSort(arr, n, exp); 
          
  } 
  
  //variables for probing
  /*static int comp = 0;
  static int moves = 0;
  static int time = 0;*\

  /* A utility function to print array of size n */
  static void printArray(int arr[]) 
  { 
      int n = arr.length; 
      for (int i=0; i<n; ++i) 
          System.out.print(arr[i]+" "); 
      System.out.println(); 
  } 
  
  static int getMax(int arr[], int n) 
  { 
      int mx = arr[0]; 
      for (int i = 1; i < n; i++) {
          if (arr[i] > mx) 
              mx = arr[i]; 
      }
      return mx; 
  } 

  // A function to do counting sort of arr[] according to 
  // the digit represented by exp. 
  static void countSort(int arr[], int n, int exp) 
  { 
      int output[] = new int[n]; // output array 
      int i; 
      int count[] = new int[10]; 
      Arrays.fill(count,0); 

      // Store count of occurrences in count[] 
      for (i = 0; i < n; i++) 
          count[ (arr[i]/exp)%10 ]++; 

      // Change count[i] so that count[i] now contains 
      // actual position of this digit in output[] 
      for (i = 1; i < 10; i++) 
          count[i] += count[i - 1]; 

      // Build the output array 
      for (i = n - 1; i >= 0; i--) 
      { 
          output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
          count[ (arr[i]/exp)%10 ]--; 
          moves++;
      } 

      // Copy the output array to arr[], so that arr[] now 
      // contains sorted numbers according to curent digit 
      for (i = 0; i < n; i++) 
          arr[i] = output[i]; 
  } 
}
