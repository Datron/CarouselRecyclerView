# CarouselRecyclerView v1.0

Create a Carousel of Recycler Views that shows different data based on the header. Works with any kind of RecyclerView layouts like linear or grid.

<img src="https://i.imgur.com/9USneXZ.gif" alt="gif2" width="350" height="600"> <img src="https://i.imgur.com/xTeNWF3.gif" alt="gif2" width="350" height="600">


# Gradle

Place the following in your app's build.gradle file
```Groovy
implementation 'com.datron.carouselrecyclerviewlibrary:carouselrecyclerviewlibrary:1.0.0'
```
# Implementation

CarouselRecyclerView requires you to define the behaviour and layout of your view holder and recycler view adapter. It works with custom layouts.

Steps to implement CarouselRecyclerView
- Implement the standard RecyclerView.ViewHolder (within your recycler view adapter)
  ```Java
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // implement stuff here
        ....
    }
    ```
- Create a custom RecyclerViewAdapter by extending `CarouseRecyclerAdapter<YourCustomViewHolder>`

  ```Java
  public class MyRecyclerAdapter extends  CarouselRecyclerAdapter<MyRecyclerAdapter.MyViewHolder> {

  }
  ```
- Implement the standard recycler view adapter methods as well as `public void setDataSource(Object data)`

- Create `CarouselRecyclerViewFragment` in the activity that you want to place CarouselRecyclerView in. After declaring the object you must call `init` and pass as arguments - RecyclerViewAdapter, RecyclerView layout manager, labels for each Carousel (the text between the arrows) and the data in the form of a `List<T>`.
    ```Java
    CarouselRecyclerViewFragment fragment = new CarouselRecyclerViewFragment();
    String[] headers = {"JavaScript","Java","C++","Python"};
    MyRecyclerAdapter adapter = new MyRecyclerAdapter(data);
    fragment.init(adapter,new LinearLayoutManager(this),headers,createList());
    ```
    createList is as follows:

    ```Java
    private List<ArrayList<String>> createList() {
        ArrayList<String> data1 = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        ArrayList<String> data3 = new ArrayList<>();
        ArrayList<String> data4 = new ArrayList<>();
        data1.add("121;10:30am;Javascript and the future of the Web; Dr Das");
        data1.add("221;11:00am;React JS workshop; Ram Shankar");
        data1.add("324;1:00pm;Angular 4 workshop; Penelope Harris");
        data2.add("742;10:30am;Java 11 - Whats new; Vishal P");
        data2.add("521;11:00am;Spring framework; Robert Downey Jr");
        data3.add("634;10:30am;C++ - Using the Standard Library; Master Chief");
        data3.add("871;11:00am;Know your pointers; Spiderman");
        data3.add("322;9:00am;Writing tests for C++ code; Vladmir Kolgromov");
        data3.add("424;1:00pm;C++ and the Blockchain; Napolean Bonaparte");
        data4.add("524;11:00am;Python and Data Science; Ravi G");
        data4.add("511;1:00pm;Testing and Python; Pablo Escobar");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        return data;
    }
    ```
- Add the fragment to a layout. In this example `root` is the id of a `LinearLayout`.
    ```Java
     FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.add(R.id.root,fragment).commit();
    ```
