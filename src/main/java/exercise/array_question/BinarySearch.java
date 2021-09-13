package exercise.array_question;

public class BinarySearch {

    /**
     *
     * @param array
     * @param target 目标值
     * @return 下标
     */
    public int binarySearch1(int[] array,int target){

        if(array == null || array.length <= 0){
            return -1;
        }
        //[i,j] 范围里寻找target
        int i=0, j = array.length-1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                //target 在 [mid+1,j] 中
                i = mid + 1;
            }else{
                //target 在 [i,mid-1] 中
                j = mid - 1;
            }
        }
        return -1;
    }


    public int binarySearch2(int[] array,int target){

        if(array == null || array.length <= 0){
            return -1;
        }
        //[i,j) 范围里寻找target
        int i=0, j = array.length;
        //当 i=j时，区间 [i,j)无效
        while(i < j){
            int mid = i + (j - i)/2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                //target 在 [mid+1,j) 中
                i = mid + 1;
            }else{
                //target 在 [i,mid) 中
                j = mid;
            }
        }
        return -1;
    }

    public int binarySearch3(int[] array,int target){

        if(array == null || array.length <= 0){
            return -1;
        }
        //(i,j] 范围里寻找target
        int i = -1, j = array.length - 1;
        //当 i=j时，区间 (i,j]无效
        while(i < j){
            int mid = i + (j - i)/2 + 1;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                //target 在 (mid,j) 中
                i = mid;
            }else{
                //target 在 (i,mid+1] 中
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,8,10,11,14};
        BinarySearch search = new BinarySearch();
        System.out.println(search.binarySearch3(array,3));
    }

}
