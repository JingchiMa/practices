package interviews.Houzz;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
    private Iterator<NestedInteger> curIterator;
    private Boolean hasNext = null;
    private Integer next = null;

    // assume nestedList is not null
    public NestedIterator(List<NestedInteger> nestedList) {
        this.curIterator = nestedList.iterator();
    }

    @Override
    // assumption: there's a next element when we call next()
    public Integer next() {
        if (this.next == null) {
            moveToNext();
        }
        Integer res = this.next;
        this.next = null;
        this.hasNext = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        if (this.hasNext == null) {
            moveToNext();
        }
        return this.hasNext;
    }


    // set this.next to be the next integer, null if there's no more integers
    private void moveToNext() {
        this.next = null;
        this.hasNext = false;
        while (curIterator.hasNext() || !stack.isEmpty()) {
            if (curIterator.hasNext()) {
                NestedInteger cur = curIterator.next();
                if (cur.isInteger()) {
                    this.next = cur.getInteger();
                    this.hasNext = true;
                    return;
                } else {
                    stack.offerFirst(curIterator);
                    curIterator = cur.getList().iterator();
                }
            } else {
                curIterator = stack.pollFirst();
            }
        }
    }
}
