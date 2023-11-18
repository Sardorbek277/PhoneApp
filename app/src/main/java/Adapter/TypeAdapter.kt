package Adapter

import Utils.MyData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.phoneapp1.R
import com.example.phoneapp1.databinding.ActivityMainBinding

class TypeAdapter(context: Context, val list: List<String>,val itemGridOnClick: ItemGridOnClick):ArrayAdapter<String>(context, R.layout.item_grid, list)
{


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView : View
        if (convertView!=null){
            itemView = convertView

        }else{
            itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        }

        itemView.findViewById<TextView>(R.id.txt_item_grid).text = list[position]
        itemView.findViewById<CardView>(R.id.card_item).setOnClickListener {
            itemGridOnClick.onClick(list[position],position)

        }


        return itemView

    }
    interface ItemGridOnClick{
        fun onClick(type: String, position: Int )
    }
}