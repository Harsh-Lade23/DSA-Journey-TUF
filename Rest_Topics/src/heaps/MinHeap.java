package heaps;

public class MinHeap {
    private void printArray(int []arr){
        System.out.print("Array: ");
        for (int i=1;i<=size;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    int []minHeap;
    int size;
    public MinHeap(){
        minHeap=new int[101];
        size=0;
    }
    private void swap(int[]arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void add(int x){
        if(size==100){
            System.out.println("Limit exceeded");
            return;
        }
        minHeap[size+1]=x;
        size++;
        if(size==1) {
            printArray(minHeap);
            return;
        }
        int curr=size;
        while(curr>1){
            if(minHeap[curr/2]<minHeap[curr]) {
                printArray(minHeap);
                return;
            }
            swap(minHeap, curr, curr/2);
            curr=curr/2;
        }
        printArray(minHeap);
    }
    public int remove(){
        if(size==0){
            System.out.println("Heap is empty");
            return -1;
        }
        int toReturn=minHeap[1];
        if(size==1){
            size--;
            printArray(minHeap);

            return toReturn;
        }
        minHeap[1]=minHeap[size];
        size--;
        int current=1;
        while (current<=size){
            if(size>=current*2 && size>=current*2+1){
                if(minHeap[current*2]<minHeap[current*2+1]){
                    swap(minHeap, current, current*2);
                    current=current*2;
                }
                else {
                    swap(minHeap, current, current*2+1);
                    current=current*2+1;
                }
            }
            if(size>=current*2 && minHeap[current*2]<minHeap[current]){
                swap(minHeap, current, current*2);
                current=current*2;
            }
            else if(size>=current*2+1 && minHeap[current*2+1]<minHeap[current]){
                swap(minHeap, current, current*2+1);
                current=current*2+1;
            }
            else {
                printArray(minHeap);

                return toReturn;
            }
        }
        printArray(minHeap);

        return toReturn;
    }
    public int get(){
        return minHeap[1];
    }
    public int size(){return size;}
}
