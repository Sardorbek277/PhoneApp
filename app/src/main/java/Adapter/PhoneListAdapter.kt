package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phoneapp1.R
import com.example.phoneapp1.databinding.ActivityPhoneListBinding
import models.Phone

class PhoneListAdapter(context: Context,val  list: List<Phone>, var itemClickLislPhones: ItemClickLislPhones):ArrayAdapter<Phone>(context, R.layout.item_phone_list, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView : View
        if (convertView!=null){
            itemView = convertView

        }else{
            itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_phone_list, parent, false)
        }
            itemView.findViewById<View>(position)
            itemView.findViewById<View>(R.id.list_phones).setOnClickListener {
            itemClickLislPhones.onClick(list[position],position)
        }
        return itemView
    }
interface ItemClickLislPhones{
    fun onClick(phone: Phone, position: Int)
}
}