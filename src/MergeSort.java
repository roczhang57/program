public class MergeSort{
    public void sort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length-1);
    }

    public void mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int mid = (high+low)/2;
            mergesort(array, helper, low, mid);
            mergesort(array, helper, mid+1, high);
            merge(array, helper, low, mid, high);
        }
    }

    public void merge(int[] array, int[] helper, int low, int mid, int high){

        for(int i = low; i <= high; i++){
            helper[i] = array[i];
        }

        int left = low;
        int right = mid+1;
        int current = low;

        while(left <= mid && right <= high){
            if(helper[left] < helper[right]){
                array[current] = helper[left];
                left++;
            }else{
                array[current] = helper[right];
                right++;
            }
            current++;
        }

        int remaining = mid - left;
        for(int i = 0; i <= remaining; i++)
            array[current+i] = helper[left+i];
    }

    public static void main(String[] args){
        int[] array = {4,6,8,3,5,0,1,2,3,7,100,45};
        MergeSort s = new MergeSort();
        s.sort(array);
        for(int a : array){
            System.out.print(a + " ");
        }
    }
}