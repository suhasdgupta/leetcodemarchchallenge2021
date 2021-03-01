class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for(int element:candyType){
            set.add(element);
        }
        
        return candyType.length/2<set.size()? candyType.length/2:set.size();
    }
}
