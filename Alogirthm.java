import java.util.Arrays;
import java.util.Comparator;

public class Alogirthm {

        public static void main(String[] args) {


        	// inputs for zip codes ranges
            int[][] Ranges = new int[][] {     new int[] { 94133, 94133 },
                                                new int[] { 94226, 94399 },
                                                new int[] { 94200, 94299 }

                                            };

                                          
            int[][] normalizedRanges = getTheNormalizedRanges(Ranges);

            //display output
            display(normalizedRanges);


        }

        //process to implement logic
        private static int[][]  getTheNormalizedRanges(int[][] RangesToNormalize) {

            int[][] newrange = new int[RangesToNormalize.length][];

            boolean[] rangePurged = new boolean[RangesToNormalize.length];

            int newIndex = 0;


            sortRange(RangesToNormalize);

            for (int i = 0; i < RangesToNormalize.length; i++) {


                if (rangePurged[i])
                    continue;


                if (i == (RangesToNormalize.length - 1) ){
                    newrange[newIndex] = RangesToNormalize[i];
                    break;
                }



                int min = RangesToNormalize[i][0];
                int max = RangesToNormalize[i][1];

                int nextMin = RangesToNormalize[i + 1][0];
                int nextMax = RangesToNormalize[i + 1][1];

                if (max >= nextMin) {

                    if (max >= nextMax)
                        newrange[newIndex] = new int[] { min, max };
                    else
                        newrange[newIndex] = new int[] { min, nextMax };

                    //keep track of the ranges that are purged from the original list.

                    rangePurged[i+1] = true;

                } else {

                    //if there is no overlap, add the current range to the new list

                    newrange[newIndex] = RangesToNormalize[i];
                }

                newIndex++;

            }

            return newrange;

        }


        private static void display(int[][] printRange){

            if(printRange == null || printRange.length <=0)
                throw new IllegalArgumentException("printRange is empty or null");

            for (int i = 0; i < printRange.length; i++) {


                if (printRange[i] != null)
                {   

                    System.out.println("["+ printRange[i][0] + ", "
                            + printRange[i][1]+"]");
                }
            }
        }



        private static void sortRange(int[][] rangeToSort){

            Arrays.sort(rangeToSort, new Comparator<int[]>() {

                @Override
                public int compare(int[] range1, int[] range2) {

                    int range1Min = range1[0];
                    int range2Min = range2[0];

                    if (range1Min > range2Min)
                        return 1;

                    if (range1Min < range2Min)
                        return -1;

                    return 0;
                }

            });
        }
    }
