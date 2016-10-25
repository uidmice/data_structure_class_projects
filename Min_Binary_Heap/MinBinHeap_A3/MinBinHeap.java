package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private static final int arraySize = 10000; // Everything in the array will
												// initially
												// be null. This is ok! Just
												// build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for
													// simplicity
													// of child/parent
													// computations...
													// the book/animation page
													// both do this.
	}

	// Please do not remove or modify this method! Used to test your entire
	// Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		// TODO Auto-generated method stub
		if (size == 0) {
			array[1] = entry;
		} else {
			int pc = size + 1;
			boolean flag = true;
			while (flag) {
				int mother = pc / 2;
				flag = array[mother].getPriority() > entry.getPriority();
				if (flag) {
					array[pc] = array[mother];
					pc = mother;
				}
			}
			array[pc] = entry;
		}
		size++;
	}

	@Override
	public void delMin() {
		// TODO Auto-generated method stub
		if (size == 0)
			;
		else {
			int pc = 1;
			EntryPair moving = array[size];
			array[size] = null;
			size--;
			down(pc,moving);
		}
	}

	@Override
	public EntryPair getMin() {
		// TODO Auto-generated method stub
		if (size == 0)
			return null;
		else
			return array[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		// TODO Auto-generated method stub
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
		}
		size = entries.length;
		int rest=size;

		if (size % 2 == 0) {
			rest=size-1;
			if (array[size/2].getPriority() > array[size].getPriority()) {
				EntryPair t = array[size/2];
				array[size/2]=array[size];
				array[size]=t;
			}
		}
		for (int i=rest/2;i>0;i--){
			down (i,array[i]);
		}
	}

	private int childs(int mother) {
		if (size < mother * 2)
			return 0;
		else if (size == mother * 2)
			return 1;
		else
			return 2;
	}
	
	void down(int pc,EntryPair moving){
		boolean flag = true;
		while (flag) {
			int childs = childs(pc);
			if (childs == 0) {
				flag = false;
				array[pc] = moving;
			} else if (childs == 1) {
				flag = array[pc * 2].getPriority() < moving.getPriority();
				if (flag) {
					array[pc] = array[pc * 2];
					pc = pc * 2;
				} else {
					array[pc] = moving;
				}
			} else {
				int left = array[pc * 2].getPriority();
				int right = array[pc * 2 + 1].getPriority();

				EntryPair smaller = null;
				if (left < right)
					smaller = array[pc * 2];
				else
					smaller = array[pc * 2 + 1];

				flag = moving.getPriority() > smaller.getPriority();

				if (flag) {
					array[pc] = smaller;
					if (left < right)
						pc = pc * 2;
					else
						pc = pc * 2 + 1;
				} else {
					array[pc] = moving;
				}
			}
		}
	}
}