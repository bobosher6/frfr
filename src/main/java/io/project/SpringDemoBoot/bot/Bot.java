package io.project.SpringDemoBoot.bot;

import lombok.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
        if (update.hasMessage() && message.hasText()){
            Scanner scanner = new Scanner(System.in);
            String text=message.getText();
            SendMessage sendMessage=new SendMessage();
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setReplyToMessageId(update.getMessage().getMessageId());
            sendMessage.setText(update.getMessage().getText());
            String msg=null;
            Double a = null;
            if (text.equals("/start")){
                User user =message.getFrom();
                msg=String.format("     Assalomu alaykum  \uD83D\uDEC2 %s \n InfoCustomsUz botga xush kelibsiz! \n Tilni tanlang!",user.getFirstName());
                sendMessage.setReplyMarkup(langsButton());//tilni tanlash boshlandi
            }else if (text.equals("\uD83C\uDDFA\uD83C\uDDFF Uz")){
                msg="O'zbekiston Respublikasiga kirayapsizmi yoki chiqayapsizmi:";
                sendMessage.setReplyMarkup(getPerevodBtn());
            }else if (text.equals("\uD83C\uDDF7\uD83C\uDDFA Ru")){
                msg="Вы въезжаете или выезжаете из Республики Узбекистан:";
                sendMessage.setReplyMarkup(getPerevodBtnRu());
            }else if (text.equals("\uD83C\uDDEC\uD83C\uDDE7 En")){
                msg = "Are you entering or leaving the Republic of Uzbekistan:";
                sendMessage.setReplyMarkup(getPerevodBtnEn());}
            else if (text.equals("Kirish")) {
                msg = "Qaysi chegara bojxona postidan kirmoqchisiz?";
                sendMessage.setReplyMarkup(getWay());
            }//kirish chiqish boshlandi
            else if (text.equals("Chiqish")) {
                msg = "Qaysi chegara bojxona postidan chiqmoqchisiz?";
                sendMessage.setReplyMarkup(getWayChiqish());
            } else if (text.equals("\uD83D\uDD19  Qaytish")) {
                msg = "Tilni sozlash";//kirish
                sendMessage.setReplyMarkup(langsButton());
            } else if (text.equals("\uD83D\uDE97 Avto")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyor());
            } else if (text.equals("\uD83D\uDE97   Avto")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyorChiqish());
            } else if (text.equals("\uD83D\uDE84 Temiryo'l")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyorT());
            } else if (text.equals("✈️ Aeroport")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyorA());
            } else if(text.equals("\uD83D\uDD19  Qаytish")) {
                msg = "Qaytish ";
                sendMessage.setReplyMarkup(getPerevodBtn());
            }else if (text.equals("Asosiy tushunchalar")){
                msg = "Bojxona brokeri — bojxona rasmiylashtiruvi bo‘yicha operatsiyalarni deklarant yoki vakolatli shaxsning topshirig‘iga binoan va uning nomidan shartnoma asosida amalga oshiradigan O‘zbekiston Respublikasi yuridik shaxsi; \n\n" +
                        "Valyuta kursi — chet el valyutasining O‘zbekiston Respublikasi valyutasiga nisbatan kursi;\n\n" +
                        "Valyuta operatsiyalari — valyuta qimmatliklariga bo‘lgan mulk huquqining va boshqa huquqlarning o‘tishi bilan bog‘liq operatsiyalar, valyuta qimmatliklaridan to‘lov vositasi sifatida foydalanish, valyuta qimmatliklarini O‘zbekiston Respublikasiga olib kirish, jo‘natish va o‘tkazish, shuningdek O‘zbekiston Respublikasidan olib chiqish, jo‘natish va o‘tkazish, rezidentlar va norezidentlar o‘rtasida O‘zbekiston Respublikasi valyutasidagi operatsiyalar;\n\n" +
                        "Valyuta qimmatliklari — chet el valyutasi, nominali chet el valyutasida ifodalangan qimmatli qog‘ozlar va to‘lov hujjatlari, norezidentlar tomonidan chiqarilgan, nominalga ega bo‘lmagan qimmatli qog‘ozlar, sof quyma oltin;\n\n" +
                        "Chet el valyutasi — muomaladagi hamda chet davlat (chet davlatlar guruhlari) hududida naqd to‘lovning qonuniy vositasi bo‘lgan pul belgilari, shuningdek muomaladan chiqarilayotgan yoki muomaladan chiqarilgan, ammo almashtirilishi lozim bo‘lgan pul belgilari, chet davlatlarning (chet davlatlar guruhlarining) pul birliklarida hamda xalqaro pul birliklarida yoki hisob-kitob birliklarida bank hisobvaraqlarida va omonatlarida turgan mablag‘lar;\n\n" +
                        "O‘zbekiston Respublikasi valyutasi (milliy valyuta) — O‘zbekiston Respublikasining pul birligi (so‘m)\n\n" +
                        "https://t.me/bojxona_rejimlari_16 ";

            }else if (text.equals("\uD83D\uDD19Qaytish")){
                msg = "Qaytish";
                sendMessage.setReplyMarkup(getWay());
            }else if (text.equals("\uD83D\uDCB0 Valyuta")){
                msg = "InfoCustomsUz.bot\n\n" +
                        "\uD83D\uDCB8 Jismoniy shaxslar tomonidan O‘zbekiston Respublikasi hududiga bojxona nazorati qoidalariga rioya qilgan holda, naqd valyuta mablag‘larini olib kirish cheklanmagan miqdorda amalga oshiriladi.\n\n" +
                        "\uD83D\uDCB8Jismoniy shaxslar 100 000 000 (yuz million) so'm ekvivalentidan ko'p miqdorda olib kelinayotgan bo'lsa deklaratsiya qilinishi shart!\n\n" +
                        "\uD83D\uDCDD Manba: https://lex.uz/docs/-3540203?ONDATE=05.04.2022%2000";
                sendMessage.setReplyMarkup(getMeyor());
            }else if (text.equals("Ta'qiqlar")){
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "❗️ Davlat va jamiyat tuzumini qo‘porishga, hududiy yaxlitlik, siyosiy mustaqillik va davlat suverenitetini buzishga yo‘naltirilgan, urush, terrorizm, zo‘ravonlik, milliy ustunlik va diniy nafratni, irqchilik va uning turlari (antisemitizm, fashizm)ni targ‘ib qiluvchi bosma asarlar, qo‘lyozmalar, klishelar, rasmlar, fotosuratlar, fotoplyonkalar, negativlar, kino-, video- va audiomahsulotlar, gramzapislar, ovozli materiallar, shuningdek, pornografiya mazmunidagi materiallar.\n\n" +
                        "\uD83D\uDCDD Manba: O‘zbekiston Respublikasi Prezidentining 2017-yil 15-dekabrdagi PF-5286-sonli Farmoniga";

                sendMessage.setReplyMarkup(getMeyor());

            }else if (text.equals("Olib kirish me'yorlari")){
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "Bojxona to‘lovlariga tortilmaydigan respublikaga jismoniy shaxslar tomonidan olib kiriladigan tovarlarni ayrim turlari normalari:\n" +
                        "\n" +
                        "1.\uD83E\uDD42 Alkogol mahsuloti, shu jumladan pivo----->umumiy miqdori 2 litrdan ko‘p bo‘lmagan \n" +
                        "\n" +
                        "2.\uD83D\uDEAC Tamaki mahsulotlarining barcha turlari----->umumiy miqdori 10 qutidan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "3.\uD83D\uDECD Atir va ifor taratuvchi suvlar----->umumiy miqdori 3 tadan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Qimmatbaho metallar va qimmatbaho toshlardan zargarlik buyumlari----->umumiy og‘irligi 65 grammdan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "Jismoniy shaxs tomonidan respublikaga olib kiriladigan, bojxona to‘lovlariga tortilmaydigan tovarlarning chegaralangan normalari:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F  O‘zbekiston Respublikasi Davlat chegaralarining avtoyo‘l (piyoda) bojxona chegaralari o‘tish punktlari orqali olib o‘tishda — 300 (uch yuz) AQSh dollari;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Prezidentining 2018-yil 6-fevraldagi PQ-3512-son qarori";
                sendMessage.setReplyMarkup(getMeyor());
            } else if (text.equals("Olib kirish me'yоrlаri")) {
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "Bojxona to‘lovlariga tortilmaydigan respublikaga jismoniy shaxslar tomonidan olib kiriladigan tovarlarni ayrim turlari normalari:\n" +
                        "\n" +
                        "1.\uD83E\uDD42 Alkogol mahsuloti, shu jumladan pivo----->umumiy miqdori 2 litrdan ko‘p bo‘lmagan \n" +
                        "\n" +
                        "2.\uD83D\uDEAC Tamaki mahsulotlarining barcha turlari----->umumiy miqdori 10 qutidan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "3.\uD83D\uDECD Atir va ifor taratuvchi suvlar----->umumiy miqdori 3 tadan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Qimmatbaho metallar va qimmatbaho toshlardan zargarlik buyumlari----->umumiy og‘irligi 65 grammdan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "Jismoniy shaxs tomonidan respublikaga olib kiriladigan, bojxona to‘lovlariga tortilmaydigan tovarlarning chegaralangan normalari:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F  O‘zbekiston Respublikasining xalqaro aeroportlari bojxona chegaralari orkali olib o‘tishda — 2 000 (ikki ming) AQSh dollari;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Prezidentining 2018-yil 6-fevraldagi PQ-3512-son qarori";
            } else if (text.equals("Olib kirish me`yorlari")) {
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "Bojxona to‘lovlariga tortilmaydigan respublikaga jismoniy shaxslar tomonidan olib kiriladigan tovarlarni ayrim turlari normalari:\n" +
                        "\n" +
                        "1.\uD83E\uDD42 Alkogol mahsuloti, shu jumladan pivo----->umumiy miqdori 2 litrdan ko‘p bo‘lmagan \n" +
                        "\n" +
                        "2.\uD83D\uDEAC Tamaki mahsulotlarining barcha turlari----->umumiy miqdori 10 qutidan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "3.\uD83D\uDECD Atir va ifor taratuvchi suvlar----->umumiy miqdori 3 tadan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Qimmatbaho metallar va qimmatbaho toshlardan zargarlik buyumlari----->umumiy og‘irligi 65 grammdan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "Jismoniy shaxs tomonidan respublikaga olib kiriladigan, bojxona to‘lovlariga tortilmaydigan tovarlarning chegaralangan normalari:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F   O‘zbekiston Respublikasi Davlat chegaralarining temir yo‘l va daryo bojxona chegaralari o‘tish punktlari orqali olib o‘tishda — 1 000 (bir ming) AQSh dollari;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Prezidentining 2018-yil 6-fevraldagi PQ-3512-son qarori";;
            } else if (text.equals("Ruxsаt")) {
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "Jismoniy shaxslar tomonidan O‘zbekiston Respublikasi Davlat chegarasining aviatsiya o‘tkazish punktlari orqali bojxona to‘lovlari undirilmaydigan ayrim tovarlarni olib o‘tishning miqdor normalari:\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCF1 1. Telefon apparati, shu jumladan, mobil aloqa moduliga ega bo‘lgan mobil telefonlar va qurilmalar  ➖ 2 dona chegarani har bir kesib o‘tishda (kelishda)\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Vazirlar mhakmasining 2018-yil 22-iyundagi VM-463-son qarori";
            } else if (text.equals("Ruxsat")){
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "Jismoniy shaxslar tomonidan O‘zbekiston Respublikasi Davlat chegarasining avtoyo‘l (yo‘lovchi) o‘tkazish punktlari orqali bojxona to‘lovlari undirilmaydigan ayrim tovarlarni olib o‘tishning miqdor normalari:\n" +
                        "\n" +
                        "1.  Sovutgich-->1 dona-->6 oy\n" +
                        "2.  Muzlatgich-->1 dona-->6 oy\n" +
                        "3.  Konditsioner-->1 dona-->6 oy\n" +
                        "4.  Kir yuvish mashinasi-->1 dona-->6 oy\n" +
                        "5.  Chang yutgich-->1 dona-->6 oy\n" +
                        "6.  Gaz plitasi-->1 dona-->6 oy\n" +
                        "7.  Elektr plita-->1 dona-->6 oy\n" +
                        "8.  Televizor-->1 dona-->6 oy\n" +
                        "9.  Mikroto'lqinli pech-->1 dona-->6 oy\n" +
                        "10.  Duxovkali pech-->1 dona-->6 oy\n" +
                        "11.  Elektr go'sht qiymalagich-->1 dona-->6 oy\n" +
                        "12.  Dazmol-->1 dona-->6 oy\n" +
                        "13.  Fen-->1 dona-->6 oy\n" +
                        "14.  Oshxona kombayni-->1 dona-->6 oy\n" +
                        "15.  Telefon-->1 dona-->6 oy\n" +
                        "16.  Kompyuter texnikasi-->1 dona-->6 oy\n" +
                        "17.  Printer-->1 dona-->6 oy\n" +
                        "18.  Planshet kompyuter-->1 dona-->6 oy\n" +
                        "19.  Noutbuk-->1 dona-->6 oy\n" +
                        "20.  Oshxona idishlari-->1 to'plam-->6 oy\n" +
                        "21.  Boshqa tovarlar-->har bir nomdagi tovardan 2 kg umumiy og‘irlik 10 kg dan oshmasligi kerak-->1oy\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Vazirlar mhakmasining 2018-yil 22-iyundagi VM-463-son qarori";
                sendMessage.setReplyMarkup(getMeyor());
            }else if (text.equals("Qo'shimcha ma'lumotlar")){
                msg = "\uD83E\uDD16 t.me/InfoCustomsUzBot \n\n" +
                        "❕ Notijorat maqsadlar uchun O‘zbekiston Respublikasining Davlat chegarasidan o‘tish punktlari orqali qo‘l yukida va kuzatib borilayotgan bagajida tovarlar olib kirayotgan jismoniy shaxslar uchun, shuningdek, jismoniy shaxs nomiga xalqaro pochta va kuryerlik jo‘natmalari orqali keladigan tovarlarga nisbatan qonun hujjatlarida belgilangan bojxona boji, qo‘shilgan qiymat solig‘i va aksiz solig‘i o‘rniga yagona bojxona to‘lovini to‘lashni nazarda tutuvchi bojxona to‘lovlarini undirishning soddalashtirilgan tartibi joriy etiladi.\n" +
                        "\n" +
                        "Jismoniy shaxslar tomonidan shaxsiy ehtiyojlari uchun bojxona chegarasi orqali qo‘l yukida, kuzatib borilayotgan bagajida, shuningdek, pochta jo‘natmalari orqali olib kiriladigan hayvonotga mansub oziq-ovqat mahsulotlarida ishlab chiqarish o‘rovining majburiy mavjudligi to‘g‘risidagi talab o‘rnatiladi.\n" +
                        "\n" +
                        "Yagona bojxona to‘lovi bojxona to‘lovlari undirilmaydigan tovarlarni jismoniy shaxslar tomonidan respublikaga olib kirishning cheklangan me’yorlaridan ortgan taqdirda, O‘zbekiston Respublikasi Tashqi iqtisodiy faoliyat tovar nomenklaturasi kodidan va kelib chiqish mamlakatidan qat’i nazar tovarlarning barcha toifalari bo‘yicha bojxona qiymatidan kelib chiqqan holda, cheklangan me’yorlardan ortiq qismiga nisbatan undiriladi.\n" +
                        "\n" +
                        "Yagona bojxona to‘lovi stavkasi - tovarning bojxona qiymatidan 30 foiz, lekin har bir kilogrami uchun 3 AQSh dollaridan kam bo‘lmagan miqdorda undiriladi.\n" +
                        "\n" +
                        "❕ Jismoniy shaxslar tomonidan shaxsiy ehtiyojlari uchun olib kiriladigan tovarlar toifasiga kirmaydigan tovarlar:\n" +
                        "1. Ichki yonuv dvigatellari.\n" +
                        "2. O‘zbekiston Respublikasi TIF TN 8403 10 subpozitsiyasida tasniflanuvchi markaziy isitish qozonlari.\n" +
                        "3. O‘zbekiston Respublikasi TIF TN 8426 — 8430, 8433 — 8442, 8444 00 — 8449 00 000 0, 8453 — 8464, 8465, 8466, 8468, 8474 — 8480, 8486, 8514, 8530, 8534 00, 8535, 8545, 8548, 9024, 9027, 9030 va 9031 tovar pozitsiyalarida tasniflanuvchi mashinalar, mexanizmlar, uskunalar (gazonlar, bog‘lar yoki sport maydonchalari uchun kosilkalar, diskli maishiy arra bundan mustasno).\n" +
                        "4. Oftobda qorayish uchun solyariylar.\n" +
                        "5. Tibbiyot texnikasi va uskunalari (shpritslar, ignalar, katetyerlar, kanyulyalar, shunga o‘xshash asboblar, qon bosimi, tana haroratini o‘lchash uskunasi, shuningdek, tibbiy ko‘rsatmalar bo‘yicha foydalanish uchun zarur bo‘lgan apparaturalar bundan mustasno).\n" +
                        "6. Tibbiyot, xirurgiya, stomatologiya yoki veterinariya mebeli (tibbiy ko‘rsatmalar bo‘yicha foydalanish uchun zarur bo‘lgan mexanik moslamali shifoxona koykalari bundan mustasno).\n" +
                        "7. Sartaroshxona kreslosi va shunga o‘xshash kreslolar, ularning qismlari.\n" +
                        "8. O‘zbekiston Respublikasi TIF TN 9010 tovar pozitsiyasida tasniflanuvchi fotolaboratoriyalar uchun apparatura va uskunalar.\n" +
                        "9. O‘zbekiston Respublikasi TIF TN 9023 00 tovar pozitsiyasida tasniflanuvchi namoyish qilish maqsadlariga mo‘ljallangan jihozlar, apparatura va modellar.\n" +
                        "10. Tangalar, banknotlar, bank kartochkalari, jetonlar yoki boshqa shunga o‘xshash to‘lov vositalari bilan harakatga keltiriladigan o‘yin avtomatlari.\n\n" +
                        "\uD83D\uDCDD Manba: O‘zbekiston Respublikasi Prezidentining 2019-yil 7-noyabrdagi PQ-4508-sonli Qarori";

            } else if (text.equals("hisob")) {
                SendMessage sendMessage1 = new SendMessage();
                sendMessage1.setText("Tugmalarni taxrirlash");
                ReplyKeyboard inlineKeyboardMarkup = null;
                sendMessage1.setReplyMarkup(inlineKeyboardMarkup);
                sendMessage1.setChatId(message.getChatId());
                try {
                    execute(sendMessage1); // Tayyorlab olgan message objectini yuborish.
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

// {...} yangi tugma yaratish kodlari
                String callBackData = null;
                if (callBackData.equals("button")) {
                    EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
                    editMessageReplyMarkup.setChatId(message.getChatId());
                    editMessageReplyMarkup.setMessageId(message.getMessageId());
                    editMessageReplyMarkup.setReplyMarkup((InlineKeyboardMarkup) inlineKeyboardMarkup);

                    try {
                        execute(editMessageReplyMarkup);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            //uzbek tilidagisi tugadi........................................................................................
            
            //rus tilidagisi boshlandi.......................................................................................
            else if (text.equals("Въезд")) {
                    msg="На какой пограничный таможенный пост вы хотите въехать?";
                    sendMessage.setReplyMarkup(getWayRu());
            } else if (text.equals("Выезд")) {
                msg = "Из какого пограничного таможенного поста вы хотите выйти?";
                sendMessage.setReplyMarkup(getMeyorRu());
            } else if (text.equals("\uD83D\uDD19 Назад")) {
                msg = "Назад";
                sendMessage.setReplyMarkup(langsButton());
            } else if (text.equals("\uD83D\uDE97 Авто")) {
                msg = "Введите стандарт:";
                sendMessage.setReplyMarkup(getMeyorRu());
            } else if (text.equals("\uD83D\uDE84 Железнодорожный")) {
                msg = "Введите стандарт:";
                sendMessage.setReplyMarkup(getMeyorRuZ());
            } else if (text.equals("✈️ Аэропорт")) {
                msg = "Введите стандарт:";
                sendMessage.setReplyMarkup(getMeyorRuAz());
            } else if (text.equals("\uD83D\uDD19  Назад")) {
                msg = "Назад";
                sendMessage.setReplyMarkup(getPerevodBtnRu());
            } else if (text.equals("\uD83D\uDCB0 Валюта")) {
            msg="\uD83D\uDCB8 Физические лица могут ввозить на территорию Республики Узбекистан наличные деньги и валюту в неограниченном количестве с соблюдением правил таможенного контроля.\n" +
                    "\n" +
                    "\uD83D\uDCB8Физические лица должны быть задекларированы, если они ввозят сумму, превышающую эквивалент 100 000 000 (сто миллионов) сумов!";
            } else if (text.equals("Лицензии")) {
                msg = "В некоммерческих целях применяется таможенная пошлина, установленная законодательством для физических лиц, ввозящих товары через пункты пропуска Государственной границы Республики Узбекистан в ручной клади и отслеживаемом багаже, а также для товаров, прибывающих на имя физического лица международными почтовыми и почтовыми отправлениями. при курьерских отправлениях будет введен упрощенный порядок взимания таможенной пошлины, предусматривающий уплату единого таможенного сбора вместо налога на добавленную стоимость и акцизного налога;\n" +
                        "\n" +
                        "Обязательное наличие производственной упаковки устанавливается в ручной клади, отслеживаемом багаже, а также в пищевой продукции животного происхождения, ввозимой физическими лицами для личных нужд через таможенную границу.\n" +
                        "\n" +
                        "В случае превышения единой таможенной пошлины пределов ввоза в республику физическими лицами товаров, в отношении которых таможенные пошлины не взимаются, таможенная стоимость всех категорий товаров независимо от кода товарной номенклатуры Республики Узбекистан за внешнеэкономическую деятельность и страну происхождения в зависимости от причины взимается с части, превышающей ограниченные нормы\n" +
                        "\n" +
                        "единая ставка таможенной пошлины в размере 30 процентов таможенной стоимости товара, но не менее 3 долларов США за килограмм.\n" +
                        "\n" +
                        "Товары, не включенные в категорию товаров, ввозимые физическими лицами для личных нужд\n" +
                        "СПИСОК 1. Двигатель внутреннего сгорания.\n" +
                        "2. Котлы центрального отопления, отнесенные к субпозиции ТН ВЕД 8403 10 Республики Узбекистан.\n" +
                        "3. Республика Узбекистан ТН ВЕД 8426 — 8430, 8433 — 8442, 8444 00 — 8449 00 000 0, 8453 — 8464, 8465, 8466, 8468, 8474 — 8480, 8486, 8514, 8530, 8534 00, 8535, 8545 , машины, механизмы, оборудование товарных позиций 8548, 9024, 9027, 9030 и 9031 (кроме газонокосилок, садовых или спортивных газонокосилок, бытовых дисковых пил).\n" +
                        "4. Солярии для загара на солнце.\n" +
                        "5. Медицинское оборудование и оборудование (за исключением шприцев, игл, катетеров, канюль, аналогичных устройств, средств измерения артериального давления, температуры тела, а также оборудования, необходимого для применения по медицинским инструкциям).\n" +
                        "6. Мебель медицинская, хирургическая, стоматологическая или ветеринарная (за исключением больничных коек с механическими приспособлениями, необходимыми для использования по медицинским инструкциям).\n" +
                        "7. Кресло парикмахерское и аналогичные кресла, их части.\n" +
                        "8. Аппаратура и оборудование для фотолабораторий, отнесенные к ТН ВЕД 9010 Республики Узбекистан.\n" +
                        "9. Оборудование, изделия и модели, предназначенные для демонстрационных целей, классифицированные по ТИФ ТН 9023 00 Республики Узбекистан.\n" +
                        "10. Игровые автоматы, в которых используются монеты, банкноты, банковские карты, жетоны или другие подобные платежные средства.";
            } else if (text.equals("Запреты")) {
                msg = "❗\uFE0F Направленные на подрыв государственного и общественного строя, нарушение территориальной целостности, политической независимости и государственного суверенитета, пропаганду войны, терроризма, насилия, национального превосходства и религиозной ненависти, расизма и его видов (антисемитизм, фашизм) печатных произведений, рукописей, клише , картины, фотографии, фотопленки, негативы, кино-, видео- и аудиопродукция, граммофонные пластинки, звуковые материалы, а также материалы порнографического характера.\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Указ Президента Республики Узбекистан №УП-5286 от 15 декабря 2017 года.";
            } else if (text.equals("Импортные стандарты")) {
                msg = "Нормы ввоза физическими лицами отдельных видов товаров, не подлежащих обложению таможенными платежами:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Алкогольная продукция, в том числе пиво ----->общее количество не более 2 литров\n" +
                        "\n" +
                        "2. \uD83D\uDEAC Все виды табачных изделий ----->общая сумма не более 10 коробок.\n" +
                        "\n" +
                        "3. \uD83D\uDECDПарфюмерия и ароматизаторы ----->общее количество не более 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFFЮвелирные изделия из драгоценных металлов и драгоценных камней ---->общий вес не более 65 грамм.\n" +
                        "\n" +
                        "Ограниченные нормы ввоза физическими лицами в республику товаров, не облагаемых таможенными сборами:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F за провоз государственной границы Республики Узбекистан через автомобильные (пешеходные) пункты таможенного пропуска через границу - 300 (триста) долларов США;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Постановление Президента Республики Узбекистан ПП-3512 от 6 февраля 2018 года.";
            } else if (text.equals("Разрешение")) {
                msg = "Количественные нормы перевозки отдельных товаров, за которые таможенные сборы не взимаются с физических лиц, через автодорожные (пассажирские) пункты пропуска Государственной границы Республики Узбекистан:\n" +
                        "\n" +
                        "1. Холодильник --> 1 шт. --> 6 месяцев.\n" +
                        "2. Морозильник --> 1 шт. --> 6 месяцев.\n" +
                        "3. Кондиционер --> 1 шт. --> 6 месяцев.\n" +
                        "4. Стиральная машина --> 1 шт. --> 6 месяцев.\n" +
                        "5. Пылесос --> 1 шт. --> 6 месяцев.\n" +
                        "6. Газовая плита --> 1 шт. --> 6 месяцев.\n" +
                        "7. Электрическая плита --> 1 шт. --> 6 месяцев.\n" +
                        "8. Телевизор --> 1 шт. --> 6 месяцев.\n" +
                        "9. Микроволновая печь --> 1 шт. --> 6 месяцев.\n" +
                        "10. Духовка --> 1 шт. --> 6 месяцев.\n" +
                        "11. Электрическая мясорубка --> 1 шт. --> 6 месяцев.\n" +
                        "12. Утюг --> 1 шт. --> 6 месяцев.\n" +
                        "13. Фен --> 1 шт. --> 6 месяцев.\n" +
                        "14. Кухонный смеситель --> 1 шт. --> 6 месяцев.\n" +
                        "15. Телефон --> 1 шт. --> 6 месяцев.\n" +
                        "16. Компьютерное оборудование --> 1 шт. --> 6 месяцев.\n" +
                        "17. Принтер --> 1 шт. --> 6 месяцев.\n" +
                        "18. Планшетный компьютер --> 1 шт. --> 6 месяцев.\n" +
                        "19. Ноутбук --> 1 шт. --> 6 месяцев.\n" +
                        "20. Кухонная утварь --> 1 комплект --> 6 месяцев.\n" +
                        "21. Прочие товары -->2 кг товаров каждого наименования, общий вес не должен превышать 10 кг -->1 месяц.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Постановление Суда Министров Республики Узбекистан от 22 июня 2018 года № КМ-463.";
            } else if (text.equals("Базовые концепты")) {
                msg = "Таможенный брокер — юридическое лицо Республики Узбекистан, которое по поручению и от имени декларанта или уполномоченного лица совершает операции по таможенному оформлению на основании договора\n" +
                        "\n" +
                        "Валютный курс – курс иностранной валюты по отношению к валюте Республики Узбекистан;\n" +
                        "\n" +
                        "Валютные операции – операции, связанные с переходом права собственности и иных прав на валютные ценности, использованием валютных ценностей в качестве платежного средства, ввозом, отправкой и передачей валютных ценностей в Республику Узбекистан, а также выводом из них валютных ценностей. , отправление и перевод из Республики Узбекистан, операции в валюте Республики Узбекистан между резидентами и нерезидентами;\n" +
                        "\n" +
                        "Валютные активы – иностранная валюта, ценные бумаги и платежные документы, выраженные в иностранной валюте, неденоминированные ценные бумаги, выпущенные нерезидентами, чистое слитковое золото;\n" +
                        "\n" +
                        "Иностранная валюта - банкноты, находящиеся в обращении и законные средства наличного расчета на территории иностранного государства (группы иностранных государств), а также банкноты, изъятые из обращения или изъятые из обращения, но подлежащие обмену, валюта иностранных государств ( группы иностранных государств) средства на банковских счетах и депозиты в единицах и международных валютных единицах или расчетных единицах;\n" +
                        "\n" +
                        "Валюта Республики Узбекистан (национальная валюта) — денежная единица Республики Узбекистан (сумма)";
            } else if (text.equals("Импортные стандaрты")) {
                msg = "Нормы ввоза физическими лицами отдельных видов товаров, не подлежащих обложению таможенными платежами:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Алкогольная продукция, в том числе пиво ----->общее количество не более 2 литров\n" +
                        "\n" +
                        "2. \uD83D\uDEAC Все виды табачных изделий ----->общая сумма не более 10 коробок.\n" +
                        "\n" +
                        "3. \uD83D\uDECDПарфюмерия и ароматизаторы ----->общее количество не более 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFFЮвелирные изделия из драгоценных металлов и драгоценных камней ---->общий вес не более 65 грамм.\n" +
                        "\n" +
                        "Ограниченные нормы ввоза физическими лицами в республику товаров, не облагаемых таможенными сборами:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F 1000 (одна тысяча) долларов США — при пересечении таможенной границы через железнодорожные и речные пункты пропуска Государственной границы Республики Узбекистан;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Постановление Президента Республики Узбекистан ПП-3512 от 6 февраля 2018 года.";
            } else if (text.equals("Импортные стaндарты")) {
                msg = "Нормы отдельных видов товаров, ввозимых физическими лицами в республику, не облагаемых таможенными сборами:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Алкогольная продукция, в том числе пиво ----->общее количество не более 2 литров\n" +
                        "\n" +
                        "2. \uD83D\uDEAC Все виды табачных изделий ----->общая сумма не более 10 коробок.\n" +
                        "\n" +
                        "3. \uD83D\uDECDПарфюмерия и ароматизаторы ----->общее количество не более 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFFЮвелирные изделия из драгоценных металлов и драгоценных камней ---->общий вес не более 65 грамм.\n" +
                        "\n" +
                        "Ограниченные нормы ввоза физическими лицами в республику товаров, не облагаемых таможенными сборами:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F 2 000 (две тысячи) долларов США — при пересечении таможенной границы через международные аэропорты Республики Узбекистан\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Постановление Президента Республики Узбекистан ПП-3512 от 6 февраля 2018 года.";
            } else if (text.equals("\uD83D\uDD19Назад")) {
                msg = "Назад";
                sendMessage.setReplyMarkup(getWayRu());
            } else if (text.equals("Разрешениe")) {
                msg = "Ввоза через авиационные пункты пропуска Государственной границы Республики Узбекистан физическими лицами отдельных товаров, не подлежащих обложению таможенными платежами\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCF1 1. Телефонное оборудование, включая мобильные телефоны и устройства с модулем мобильной связи ➖ 2 при каждом пересечении границы (прибытии)\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Источник: Постановление Суда Министров Республики Узбекистан от 22 июня 2018 года № КМ-463.";
            }

            ////inglizcha boshlandi...........................................................................
            else if (text.equals("Enter")) {
                msg = "\n" +
                        "Which border customs post do you want to enter?";
                sendMessage.setReplyMarkup(getWayEn());
            } else if (text.equals("\uD83D\uDD19  Back")) {
                msg = "Back";
                sendMessage.setReplyMarkup(langsButton());
            } else if (text.equals("\uD83D\uDD19 Back")) {
                msg = "Back";
                sendMessage.setReplyMarkup(getPerevodBtnEn());
            } else if (text.equals("Exit")) {
                msg = "\n" +
                        "Which border customs post do you want to enter?";
                sendMessage.setReplyMarkup(getWayEn());
            } else if (text.equals("\uD83D\uDE97 Auto")) {
                msg = "Enter the standard:";
                sendMessage.setReplyMarkup(getMeyorEn());
            } else if (text.equals("\uD83D\uDE84 Railway")) {
                msg = "Enter the standart:";
                sendMessage.setReplyMarkup(getMeyorEnR());
            } else if (text.equals("✈\uFE0F Airport")) {
                msg = "Enter the standart:";
                sendMessage.setReplyMarkup(getMeyorEnA());
            } else if (text.equals("\uD83D\uDCB0 Currency")) {
                msg = "\uD83D\uDCB8 Individuals can import cash and currency into the territory of the Republic of Uzbekistan in unlimited quantities, subject to customs control rules.\n" +
                        "\n" +
                        "\uD83D\uDCB8Individuals must be declared if they import an amount exceeding the equivalent of 100,000,000 (one hundred million) soums!";
            } else if (text.equals("Import standards")) {
                msg = "Norms of certain types of goods imported by individuals into the republic that are not subject to customs payments:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Alcoholic products, including beer----->total quantity not more than 2 liters\n" +
                        "\n" +
                        "2. \uD83D\uDEAC All types of tobacco products----->total amount not more than 10 boxes\n" +
                        "\n" +
                        "3. \uD83D\uDECD Perfumes and fragrances----->total amount not more than 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Jewelery made of precious metals and precious stones---->total weight not more than 65 grams\n" +
                        "\n" +
                        "Limited norms of goods imported by an individual into the republic, which are not subject to customs fees:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F for transportation of the state borders of the Republic of Uzbekistan through road (pedestrian) customs border crossing points - 300 (three hundred) US dollars;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Resolution PD-3512 of the President of the Republic of Uzbekistan dated February 6, 2018";
            } else if (text.equals("Prohibitions")) {
                msg = "❗\uFE0F Aimed at undermining the state and social system, violating territorial integrity, political independence and state sovereignty, promoting war, terrorism, violence, national superiority and religious hatred, racism and its types (anti-Semitism, fascism) printed works, manuscripts, clichés, paintings, photographs, photographic films, negatives, film, video and audio products, gramophone records, sound materials, as well as pornographic materials.\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Decree of the President of the Republic of Uzbekistan No. PD-5286 dated December 15, 2017.";
            } else if (text.equals("Permission")) {
                msg = "Quantitative norms for transportation of certain goods for which customs fees are not collected by individuals through highway (passenger) checkpoints of the State border of the Republic of Uzbekistan:\n" +
                        "\n" +
                        "1. Cooler-->1 piece-->6 months\n" +
                        "2. Refrigerator-->1 piece-->6 months\n" +
                        "3. Air conditioner-->1 piece-->6 months\n" +
                        "4. Washing machine-->1 unit-->6 months\n" +
                        "5. Vacuum cleaner-->1 piece-->6 months\n" +
                        "6. Gas stove-->1 piece-->6 months\n" +
                        "7. Electric plate-->1 piece-->6 months\n" +
                        "8. TV-->1 piece-->6 months\n" +
                        "9. Microwave-->1 piece-->6 months\n" +
                        "10. Oven-->1 unit-->6 months\n" +
                        "11. Electric meat grinder-->1 piece-->6 months\n" +
                        "12. Iron-->1 piece-->6 months\n" +
                        "13. Hairdryer-->1 piece-->6 months\n" +
                        "14. Kitchen mixer-->1 piece-->6 months\n" +
                        "15. Phone-->1 piece-->6 months\n" +
                        "16. Computer equipment-->1 piece-->6 months\n" +
                        "17. Printer-->1 piece-->6 months\n" +
                        "18. Tablet computer-->1 piece-->6 months\n" +
                        "19. Laptop-->1 piece-->6 months\n" +
                        "20. Kitchen utensils-->1 set-->6 months\n" +
                        "21. Other goods-->2 kg of goods of each name, the total weight should not exceed 10 kg-->1 month\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Resolution No. CM-463 of the Court of Ministers of the Republic of Uzbekistan dated June 22, 2018";
            } else if (text.equals("Additional information")) {
                msg = "❕ For non-commercial purposes, for individuals importing goods through the State border crossing points of the Republic of Uzbekistan in hand luggage and tracked luggage, as well as for goods arriving in the name of an individual through international mail and courier shipments, as prescribed by law. a simplified procedure for collecting customs fees will be introduced, which provides for the payment of a single customs fee instead of duty, value added tax and excise tax.\n" +
                        "\n" +
                        "Mandatory presence of production packaging is established in hand luggage, tracked baggage, as well as in animal food products imported by individuals for their personal needs through the customs border.\n" +
                        "\n" +
                        "In the event that the single customs fee exceeds the limits of import of goods for which no customs duties are levied into the republic by individuals, the customs value of all categories of goods, regardless of the code of the commodity nomenclature of the Republic of Uzbekistan for Foreign Economic Activity and the country of origin depending on the reason, it is levied against the part that exceeds the limited norms.\n" +
                        "\n" +
                        "The uniform customs duty rate is 30 percent of the customs value of the goods, but not less than 3 US dollars per kilogram.\n" +
                        "\n" +
                        "❕ Goods not included in the category of goods imported by individuals for their personal needs:\n" +
                        "1. Internal combustion engines.\n" +
                        "2. Central heating boilers classified under subheading TIF TN 8403 10 of the Republic of Uzbekistan.\n" +
                        "3. Republic of Uzbekistan TIF TN 8426 — 8430, 8433 — 8442, 8444 00 — 8449 00 000 0, 8453 — 8464, 8465, 8466, 8468, 8474 — 8480, 8486, 8514, 8530, 8534 00, 8535, 8545 , machines, mechanisms, equipment of headings 8548, 9024, 9027, 9030 and 9031 (excluding lawn, garden or sports lawn mowers, household disc saws).\n" +
                        "4. Solariums for tanning in the sun.\n" +
                        "5. Medical equipment and equipment (with the exception of syringes, needles, catheters, cannulas, similar devices, blood pressure, body temperature measuring equipment, as well as equipment necessary for use according to medical instructions) .\n" +
                        "6. Medical, surgical, dental or veterinary furniture (excluding hospital beds with mechanical devices required for use according to medical instructions).\n" +
                        "7. Barber chair and similar chairs, their parts.\n" +
                        "8. Apparatus and equipment for photo laboratories classified under TIF TN 9010 of the Republic of Uzbekistan.\n" +
                        "9. Equipment, hardware and models intended for demonstration purposes, classified under TIF TN 9023 00 of the Republic of Uzbekistan.\n" +
                        "10. Gaming machines operated by coins, banknotes, bank cards, tokens or other similar means of payment.\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Decision of the President of the Republic of Uzbekistan No. PQ-4508 of November 7, 2019";
            } else if (text.equals("Basic concepts")) {
                msg = "Customs broker — a legal entity of the Republic of Uzbekistan, carrying out customs clearance operations on the basis of a contract on behalf of the declarant or an authorized person and on behalf of him.\n" +
                        "\n" +
                        "Exchange rate - exchange rate of foreign currency against the currency of the Republic of Uzbekistan.\n" +
                        "\n" +
                        "Currency transactions - transactions related to the transfer of ownership and other rights to currency values, use of currency values   as a means of payment, import, shipment and transfer of currency values   to the Republic of Uzbekistan, as well as O Withdrawal, sending and transfer from the Republic of Uzbekistan, operations in the currency of the Republic of Uzbekistan between residents and non-residents.\n" +
                        "\n" +
                        "Currency assets - foreign currency, securities and payment documents denominated in foreign currency, non-denominated securities issued by non-residents, pure bullion gold.\n" +
                        "\n" +
                        "Foreign currency - banknotes in circulation and legal means of cash payment in the territory of a foreign country (groups of foreign countries), as well as banknotes that are withdrawn from circulation or withdrawn from circulation but need to be exchanged, currency of foreign countries (groups of foreign countries) funds in bank accounts and deposits in units and international currency units or units of account.\n" +
                        "\n" +
                        "Currency of the Republic of Uzbekistan (national currency) — monetary unit of the Republic of Uzbekistan (sum)";
            } else if (text.equals("Import stаndards")) {
                msg="Norms of certain types of goods imported by individuals into the republic that are not subject to customs fees:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Alcoholic products, including beer----->total quantity not more than 2 liters\n" +
                        "\n" +
                        "2. \uD83D\uDEAC All types of tobacco products----->total amount not more than 10 boxes\n" +
                        "\n" +
                        "3. \uD83D\uDECD Perfumes and fragrances----->total amount not more than 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Jewelery made of precious metals and precious stones---->total weight not more than 65 grams\n" +
                        "\n" +
                        "Limited norms of goods imported by an individual into the republic, which are not subject to customs fees:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F 1000 (one thousand) US dollars - when crossing the customs border through railway and river checkpoints of the State Border of the Republic of Uzbekistan;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Resolution PQ-3512 of the President of the Republic of Uzbekistan dated February 6, 2018";
            } else if (text.equals("Impоrt standards")) {
                msg = "Norms of certain types of goods imported by individuals into the republic that are not subject to customs fees:\n" +
                        "\n" +
                        "1. \uD83E\uDD42 Alcoholic products, including beer----->total quantity not more than 2 liters\n" +
                        "\n" +
                        "2. \uD83D\uDEAC All types of tobacco products----->total amount not more than 10 boxes\n" +
                        "\n" +
                        "3. \uD83D\uDECD Perfumes and fragrances----->total amount not more than 3\n" +
                        "\n" +
                        "4.\uD83D\uDCFF Jewelery made of precious metals and precious stones---->total weight not more than 65 grams\n" +
                        "\n" +
                        "Limited norms of goods imported by an individual into the republic, which are not subject to customs fees:\n" +
                        "\n" +
                        "\n" +
                        "☑\uFE0F 2,000 (two thousand) US dollars - when crossing the customs border through international airports of the Republic of Uzbekistan;\n" +
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Resolution PQ-3512 of the President of the Republic of Uzbekistan dated February 6, 2018";
            } else if (text.equals("Permissiоn")) {
                msg = "Quantitative norms for transportation of certain goods for which customs fees are not collected by individuals through highway (passenger) checkpoints of the State border of the Republic of Uzbekistan:\n" +
                        "\n" +

                        "1. Telephone equipment, including mobile phones and devices with a mobile communication module ➖ 2 at each border crossing (arrival)"+
                        "\n" +
                        "\n" +
                        "\uD83D\uDCDD Source: Resolution No. VM-463 of the Court of Ministers of the Republic of Uzbekistan dated June 22, 2018";
            } else if (text.equals("\uD83D\uDD19Back")) {
                msg = "Back";
                sendMessage.setReplyMarkup(getWayEn());
            } else if (text.equals("\uD83D\uDCB0  Valyuta")) {
                msg = "Jismoniy shaxslar tomonidan ekvivalenti 100 000 000 (yuz million) so‘mga teng yoki undan oshmaydigan miqdordagi naqd valyuta mablag‘larini O‘zbekiston Respublikasidan tashqariga bojxona nazorati qoidalariga rioya etilgan holda cheklovlarsiz olib chiqiladi. \n" +
                        "Belgilangan summadan ortiq miqdordagi naqd valyuta mablag‘larining O‘zbekiston Respublikasi hududidan tashqariga olib chiqilishiga yo‘l qo‘yilmaydi, ushbu qoidalarning 6-bandida belgilangan holatlar bundan mustasno. \n" +
                        " \n" +
                        " Jismoniy shaxslar tomonidan ekvivalenti 100 000 000 (yuz million) so‘mdan ortiq miqdordagi naqd valyuta mablag‘larini O‘zbekiston Respublikasidan tashqariga olib chiqib ketishga quyidagi holatlarda yo‘l qo‘yiladi:\n" +
                        " \n" +
                        "  rezidentlar tomonidan — xorijiy davlatlarga xizmat safariga ketayotgan Hukumat delegatsiyasi a’zolari uchun Vazirlar Mahkamasining farmoyishi asosida;\n" +
                        " \n" +
                        "  norezidentlar tomonidan — O‘zbekiston Respublikasiga kirish chog‘ida rasmiylashtirilgan yo‘lovchi bojxona deklaratsiyasi asosida deklaratsiya qilingan mablag‘lar doirasida, shuningdek, respublikada belgilangan tartibda tashkil qilingan xalqaro musobaqalar (tanlovlar, olimpiadalar) sovrindorlari yoki qatnashchilari tomonidan mablag‘larning qonuniyligini tasdiqlovchi hujjatlar asosida.\n" +
                        " \n" +
                        "  Bunda norezident jismoniy shaxslar tomonidan O‘zbekiston Respublikasiga kirish chog‘ida to‘ldirilgan yo‘lovchi bojxona deklaratsiyasida ko‘rsatilgan naqd valyuta mablag‘laridan respublika hududida qonunchilik hujjatlarida belgilangan talablarga muvofiq foydalanilgan qoldiq miqdori doirasidagi naqd valyuta mablag‘larini O‘zbekiston Respublikasi hududidan olib chiqishga yo‘l qo‘yiladi. \n" +
                        " \n" +
                        "  Ekvivalenti 100 000 000 (yuz million) so‘mdan ortiq bo‘lgan naqd valyuta mablag‘larini olib chiqib ketish uchun asos bo‘lgan hujjatni boshqa shaxslarga berishga yo‘l qo‘yilmaydi.\n" +
                        " \n" +
                        "  Jismoniy shaxslar tomonidan naqd valyuta mablag‘larini O‘zbekiston Respublikasidan tashqariga olib chiqib ketish uchun asos bo‘ladigan hujjatlardan bir marotaba foydalanishga yo‘l qo‘yiladi va ushbu hujjatlar kelgusida naqd valyuta mablag‘larini takroran olib chiqib ketish uchun asos hisoblanmaydi.\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba: https://lex.uz/docs/-3540203?ONDATE=05.04.2022%2000";
            } else if (text.equals("Olib  chiqish me'yorlari")) {
                msg = "Jismoniy shaxslar tomonidan olib ketiladigan ayrim tovarlarning turlari normalari: \n" +
                        " \n" +
                        " \n" +
                        "1.Guruch ---- umumiy og‘irligi 3 kg.dan ko‘p bo‘lmagan \n" +
                        " \n" +
                        "2.Non-bulka mahsulotlari ---- umumiy og‘irligi 5 kg.dan ko‘p bo‘lmagan \n" +
                        " \n" +
                        "3.Go‘sht va go‘sht oziq-ovqat mahsulotlari ---- umumiy og‘irligi 2 kg.dan ko‘p bo‘lmagan \n" +
                        " \n" +
                        "4.Shakar ---- umumiy og‘irligi 2 kg.dan ko‘p bo‘lmagan \n" +
                        " \n" +
                        "5.O‘simlik moylari ---- umumiy og‘irligi 2 �g.dan ko‘p bo‘lmagan \n" +
                        " \n" +
                        "6.Yangi uzilgan meva-sabzavot mahsulotlari, uzum, poliz ekinlari, dukkakli o‘simliklari hamda quritilgan sabzavot va mevalar ---- umumiy og‘irligi 40 kg.dan ko‘p bo‘lmagan\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Prezidentining 2018-yil 6-fevraldagi PQ-3512-son qarori";
            } else if (text.equals("Тa'qiqlаr")) {
                msg = "Jismoniy shaxslar tomonidan olib ketilishi taqiqlangan tovarlar: \n" +
                        " \n" +
                        "1. Qimmatbaho metallar           VM 131 23.03.1999 \n" +
                        " \n" +
                        "2. Rangli metallar              PF 2559 04.03.2000 \n" +
                        " \n" +
                        "3. Yuqori likvidli tovarlar       VM 280 13.08.1996 \n" +
                        " \n" +
                        "4. Mineral o’g’itlar              VM 162 29.03.2021 \n" +
                        " \n" +
                        "5. Biologik obyektlar              AV 2603 24.07.2014 \n" +
                        " \n" +
                        " \n" +
                        "\uD83D\uDCDD  Manba: Bojxona qo’mitasining 2022-yil 28-fevraldagi ‘’Tashqi iqtisodiy faoliyatda notarif nazoratni \n" +
                        "tashkil etish to’grisida’’gi 44-sonli buyrug’i.";
            } else if (text.equals("Ruхsаt")) {
                msg = "Bojxona deklaratsiyasini taqdim etmagan holda respublikadan jismoniy shaxslar tomonidan olib ketiladigan tovarlarning cheklangan normalari:  \n" +
                        "5 000 (besh ming) AQSh dollari hisoblanadi.\n" +
                        "\n" +
                        "\uD83D\uDCDD Manba:O‘zbekiston Respublikasi Prezidentining 2018-yil 6-fevraldagi PQ-3512-son qarori\n" +
                        "https://lex.uz/docs/-3551264";
            } else if (text.equals("Qо'shimchа ma'lumotlar")) {
                msg = "O‘zbekiston Respublikasi Prezidentining hujjatlari yoki O‘zbekiston Respublikasi Vazirlar Mahkamasining qarorlari asosida beriladigan litsenziyalar bo‘yicha eksport-import qilinadigan maxsus tovarlar: \n" +
                        " \n" +
                        "1. Qurol-yarog‘ va harbiy texnika, ularni ishlab chiqarish uchun maxsus butlovchi buyumlar \n" +
                        " \n" +
                        "2. Uran va boshqa radioaktiv moddalar, ulardan tayyorlangan buyumlar radioaktiv moddalarining chiqindilari \n" +
                        " \n" +
                        "3. Radioaktiv moddalardan foydalanilgan priborlar va asbob-uskunalar \n" +
                        " \n" +
                        "4. Qimmatbaho metallar va ulardan tayyorlangan boshqa buyumlar\n" +
                        " \n" +
                        "\uD83D\uDCDD  Manba: O‘zbekiston Respublikasi Prezidentining  2017-yil 3-noyabrdagi ‘’MAXSUS TURDAGI TOVARLAR EKSPORTI VA IMPORTINI LITSENZIYALASH, SHUNINGDEK EKSPORT KONTRAKTLARINI RO‘YXATGA OLISH VA IMPORT KONTRAKTLARINI EKSPERTIZADAN O‘TKAZISHNI TARTIBGA SOLISH CHORA-TADBIRLARI TO‘G‘RISIDA’’gi PF-5215 sonli farmoni \n" +
                        "https://lex.uz/docs/-3470834\n" +
                        " \n" +
                        "O‘zbekiston Respublikasi Prezidenti va O‘zbekiston Respublikasi Hukumatining qarorlari asosida eksport qilinadigan buyumlar va mahsulotlar \n" +
                        " \n" +
                        "1. Chorva mollari, parranda \n" +
                        " \n" +
                        "2. Go‘sht va qo‘shimcha ozuqabop go‘shtli mahsulotlar \n" +
                        " \n" +
                        "3. Don: bug‘doy, javdari bug‘doy, arpa, suli, makkajo‘xori, guruch, grechixa \n" +
                        " \n" +
                        "4. Un, yorma \n" +
                        " \n" +
                        "5. Polietilentereftalat (PET) chiqindilari, parchalari va qirindilari \n" +
                        " \n" +
                        "6. Charm xomashyosi (nostandartlari ham), momiq mo‘yna xomashyosi, shu jumladan qorako‘l (nostandartlari ham) \n" +
                        " \n" +
                        "7. Titishga yaroqli ipak qurt pillasi, ipak xomashyosi (o‘ralmagan) \n" +
                        " \n" +
                        "8. Rangli metall parchalari va chiqindilari \n" +
                        " \n" +
                        " \n" +
                        "\uD83D\uDCDD  Manba: O‘zbekiston Respublikasi Prezidentining  2017-yil 16-dekabrdagi ‘‘TASHQI BOZORLARDA MAHALLIY MAHSULOTLAR RAQOBATDOSHLIGINI TA’MINLASH VA EKSPORTINI RAG‘BATLANTIRISHGA DOIR QO‘SHIMCHA CHORA-TADBIRLARI TO‘G‘RISIDA’’gi PF-5286 sonli farmoni\n" +
                        "https://lex.uz/docs/-3460651";
            } else if (text.equals("Asоsiy tushunchаlar")) {
                msg = "Rezident — O‘zbekiston Respublikasi fuqarolari, shu jumladan xorijdagi O‘zbekiston Respublikasi fuqarolari, O‘zbekiston Respublikasida yashash guvohnomasiga ega bo‘lgan chet el fuqarolari, O‘zbekiston Respublikasida yashash guvohnomasiga ega bo‘lgan fuqaroligi bo‘lmagan shaxslar, O‘zbekiston Respublikasi qonunchiligiga muvofiq tashkil etilgan barcha yuridik shaxslar, shuningdek ularning O‘zbekiston Respublikasida va undan tashqarida joylashgan filiallari va vakolatxonalari, O‘zbekiston Respublikasining diplomatik, savdo va boshqa rasmiy vakolatxonalari, shu jumladan O‘zbekiston Respublikasidan tashqaridagi diplomatik, savdo va boshqa rasmiy vakolatxonalari, qarorgohlari O‘zbekiston Respublikasida joylashgan xalqaro tashkilotlar O‘zbekiston Respublikasi rezidentlaridir; \n" +
                        " \n" +
                        "Norezident — Rezident tushunchasi doirasiga kirmaydigan shaxslar O‘zbekiston Respublikasi norezidentlaridir; \n" +
                        " \n" +
                        "Bojxona brokeri — bojxona rasmiylashtiruvi bo‘yicha operatsiyalarni deklarant yoki vakolatli shaxsning topshirig‘iga binoan va uning nomidan shartnoma asosida amalga oshiradigan O‘zbekiston Respublikasi yuridik shaxsi; \n" +
                        " \n" +
                        "Valyuta kursi — chet el valyutasining O‘zbekiston Respublikasi valyutasiga nisbatan kursi; \n" +
                        " \n" +
                        "Valyuta operatsiyalari — valyuta qimmatliklariga bo‘lgan mulk huquqining va boshqa huquqlarning o‘tishi bilan bog‘liq operatsiyalar, valyuta qimmatliklaridan to‘lov vositasi sifatida foydalanish, valyuta qimmatliklarini O‘zbekiston Respublikasiga olib kirish, jo‘natish va o‘tkazish, shuningdek O‘zbekiston Respublikasidan olib chiqish, jo‘natish va o‘tkazish, rezidentlar va norezidentlar o‘rtasida O‘zbekiston Respublikasi valyutasidagi operatsiyalar; \n" +
                        " \n" +
                        "Valyuta qimmatliklari — chet el valyutasi, nominali chet el valyutasida ifodalangan qimmatli qog‘ozlar va to‘lov hujjatlari, norezidentlar tomonidan chiqarilgan, nominalga ega bo‘lmagan qimmatli qog‘ozlar, sof quyma oltin; \n" +
                        " \n" +
                        "Chet el valyutasi — muomaladagi hamda chet davlat (chet davlatlar guruhlari) hududida naqd to‘lovning qonuniy vositasi bo‘lgan pul belgilari, shuningdek muomaladan chiqarilayotgan yoki muomaladan chiqarilgan, ammo almashtirilishi lozim bo‘lgan pul belgilari, chet davlatlarning (chet davlatlar guruhlarining) pul birliklarida hamda xalqaro pul birliklarida yoki hisob-kitob birliklarida bank hisobvaraqlarida va omonatlarida turgan mablag‘lar; \n" +
                        " \n" +
                        "O‘zbekiston Respublikasi valyutasi (milliy valyuta) — O‘zbekiston Respublikasining pul birligi (so‘m)";
            } else if (text.equals("\uD83D\uDE84   Temiryo'l")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyorChiqish());
            } else if (text.equals("✈️   Aeroport")) {
                msg = "Me'yorni kiriting:";
                sendMessage.setReplyMarkup(getMeyorChiqish());
            } else if (text.equals("\uD83D\uDD19Qауtish")) {
                msg = "Qaytish:";
                sendMessage.setReplyMarkup(getPerevodBtn());
            } else{
                sendMessage.setReplyMarkup(new ReplyKeyboardRemove(false));
                msg="Xato buyruq";
            }
            if(msg!=null){
                sendMessage.setText(msg);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    System.out.println(e);
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "InfoCustomsUzBot";
    }
    @Override
    public String getBotToken() {
        return "6688324168:AAFiklTB5W-cxpBmqgH6pxhpuliiXxidZQA";
    }


    @Override
    public void onRegister() {
        super.onRegister();
    }
    public ReplyKeyboardMarkup hisobButton(){
        Scanner scanner = new Scanner(System.in);
        ReplyKeyboardMarkup markup=new ReplyKeyboardMarkup();
        int a= scanner.nextInt();

        System.out.println(a);


        return markup;
    }
    public ReplyKeyboardMarkup langsButton(){
        ReplyKeyboardMarkup markup=new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();


        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83C\uDDFA\uD83C\uDDFF Uz");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83C\uDDF7\uD83C\uDDFA Ru");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83C\uDDEC\uD83C\uDDE7 En");
        row.add(button);

        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup hisob(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();
        button.setText("hisoblash");
        row.add(button);


        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getWay(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("\uD83D\uDE97 Avto");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDE84 Temiryo'l");
        row.add(button);

        button=new KeyboardButton();
        button.setText("✈️ Aeroport");
        row.add(button);
        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19  Qаytish");
        row.add(button);


        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getWayChiqish(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("\uD83D\uDE97   Avto");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDE84   Temiryo'l");
        row.add(button);

        button=new KeyboardButton();
        button.setText("✈️   Aeroport");
        row.add(button);
        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19 Qауtish");
        row.add(button);


        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getWayEn(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("\uD83D\uDE97 Auto");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDE84 Railway");
        row.add(button);

        button=new KeyboardButton();
        button.setText("✈️ Airport");
        row.add(button);
        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19 Back");
        row.add(button);


        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getWayRu(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("\uD83D\uDE97 Авто");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDE84 Железнодорожный");
        row.add(button);

        button=new KeyboardButton();
        button.setText("✈️ Аэропорт");
        row.add(button);
        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19  Назад");
        row.add(button);


        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }

    public ReplyKeyboardMarkup getPerevodBtn(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("Kirish");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Chiqish");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDD19  Qaytish");
        row.add(button);

        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getPerevodBtnEn(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("Enter");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Exit");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDD19  Back");
        row.add(button);

        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getPerevodBtnRu(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();

        button.setText("Въезд");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Выезд");
        row.add(button);

        button=new KeyboardButton();
        button.setText("\uD83D\uDD19 Назад");
        row.add(button);

        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
    public ReplyKeyboardMarkup getValyuta(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();
        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Valyuta");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Olib kirish me'yorlari");
        row.add(button);
        rows.add(row);

        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;
    }
    public ReplyKeyboardMarkup getMeyor(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Valyuta");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Olib kirish me'yorlari");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Ta'qiqlar");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Ruxsat");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Qo'shimcha ma'lumotlar");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Asosiy tushunchalar");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Qaytish");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }public ReplyKeyboardMarkup getMeyorChiqish(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0  Valyuta");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Olib  chiqish me'yorlari");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Тa'qiqlаr");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Ruхsаt");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Qо'shimchа ma'lumotlar");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Asоsiy tushunchаlar");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Qaytish ");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorEn(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Currency");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Import standards");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Prohibitions");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Permission");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Additional information");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Basic concepts");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Back");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorEnA(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Currency");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Impоrt standards");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Prohibitions");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Permissiоn");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Additional information");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Basic concepts");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Back");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorEnR(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Currency");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Import stаndards");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Prohibitions");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Permission");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Additional information");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Basic concepts");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Back");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorA(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Valyuta");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Olib kirish me'yоrlаri");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Ta'qiqlar");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Ruxsаt");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Qo'shimcha ma'lumotlar");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Asosiy tushunchalar");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Qaytish");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorT(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Valyuta");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Olib kirish me`yorlari ");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Ta'qiqlar");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Ruxsat");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Qo'shimcha ma'lumotlar");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Asosiy tushunchalar");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Qaytish");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorRuZ(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Валюта");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Импортные стандaрты");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Запреты");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Разрешение");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Лицензии");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Базовые концепты");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Назад");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorRuAz(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Валюта");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Импортные стaндарты");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Запреты");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Разрешениe");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Лицензии");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Базовые концепты");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Назад");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
    public ReplyKeyboardMarkup getMeyorRu(){
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);

        List<KeyboardRow> rows=new ArrayList<>();
        KeyboardRow row=new KeyboardRow();

        KeyboardButton button=new KeyboardButton();
        button.setText("\uD83D\uDCB0 Валюта");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Импортные стандарты");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Запреты");
        row.add(button);

        rows.add(row);

        row = new KeyboardRow();
        button=new KeyboardButton();
        button.setText("Разрешение");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Лицензии");
        row.add(button);

        button=new KeyboardButton();
        button.setText("Базовые концепты");
        row.add(button);

        rows.add(row);
        row  = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("\uD83D\uDD19Назад");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return markup;

    }
}
