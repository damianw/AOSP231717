package wtf.log.aosp231717;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private final Adapter adapter = new Adapter();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setAdapter(adapter);
  }


  @Override
  protected void onStart() {
    super.onStart();
    loadData();
  }

  @Override
  protected void onStop() {
    super.onStop();
    unloadData();
  }

  /**
   * Simulate data loading.
   */
  private void loadData() {
    adapter.size = 1000;
    adapter.notifyDataSetChanged();
  }

  /**
   * Simulate data unloading by setting the adapter size back to 0.
   */
  private void unloadData() {
    adapter.size = 0;
  }

  private static class Holder extends RecyclerView.ViewHolder {

    @NonNull final TextView textView;

    Holder(@NonNull View itemView) {
      super(itemView);
      textView = (TextView) itemView;
    }

  }

  private static class Adapter extends RecyclerView.Adapter<Holder> {

    int size = 0;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
      return new Holder(view);
    }

    @Override
    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(Holder holder, int position) {
      holder.textView.setText("This is cell " + position);
    }

    @Override
    public int getItemCount() {
      return size;
    }

  }

}
