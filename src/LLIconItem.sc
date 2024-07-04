;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use BorderWindow)
(use IconI)
(use Cycle)
(use InvI)
(use Obj)

(public
	invCode 0
	invWin 1
)

(local
	[local0 13] = [0 {leden} {únor} {bøezen} {duben} {kvìten} {èervna} {èervenec} {srpen} {záøí} {øíjen} {listopad} {prosinec}]
)
(procedure (localproc_008a param1 param2 &tmp temp0)
	(proc0_14 (+ param2 (if global179 50 else 80)) param1)
)

(class LLIconItem of IconI
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state $0000
		cursor -1
		type $4000
		message -1
		modifiers $0000
		signal $0001
		helpStr 0
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
	)
	
	(method (ownedBy)
		(return 0)
	)
)

(instance invCode of Code
	(properties)
	
	(method (init)
		(Inv
			init:
			add: ok
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)
	
	(method (doit param1)
		(switch param1
			(23
				(Inv
					add:
						Kamera
						Battery_Charger
						A_Blank_Videotape_a
						A_Blank_Videotape_b
						A_Blank_Videotape_c
						Michelle_Milken_s_Resume
						Hard_Disk_Cafe_Napkin
						AeroDork_Gold_Card
						Boarding_Pass
						AeroDork_s_In-Flight_Magazine
						Some_Change
						DayTrotter_
						Money
						Credit_Cards
						Membership_Tape
						Lana_Luscious__Resume
						Tramp_Casino_Matchbook
						Silver_Dollar
						Roller-skates
						Chi_Chi_Lambada_s_Resume
						Doc_Pulliam_s_Card
						Green_Card
						Doily
						invLook
						invHand
						invSelect
						invHelp
						ok
					eachElementDo: #highlightColor global141
					eachElementDo: #lowlightColor global139
					eachElementDo: #init
					state: 2048
				)
			)
			(24
				(Inv
					add:
						DataMan
						Reverse_Biaz_DataPak
						P__C__Hammer_DataPak
						Reverse_Biaz_Fax
						Champagne
						Gold_Record
						Cassette_Tape
						P__C__Hammer_Fax
						Letter_Opener
						Desk_Key
						Folder_Of_Evidence
						Photocopied_Evidence
						Reel_To_Reel_Tape
						Hooter_Shooter
						invLook
						invHand
						invSelect
						invHelp
						ok
					eachElementDo: #highlightColor global141
					eachElementDo: #lowlightColor global139
					eachElementDo: #init
					state: 2048
				)
			)
		)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)
	
	(method (open)
		(invLook
			nsLeft: (- (/ (- (self right?) (self left?)) 2) 68)
		)
		(super open:)
	)
)

(instance ok of LLIconItem
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal $0043
		helpStr {Kliknutím sem zavøete toto okno a vrátíte se do hry.}
	)
	
	(method (init)
		(= highlightColor 0)
		(= lowlightColor gLowlightColor_6)
		(super init:)
	)
)

(instance invLook of LLIconItem
	(properties
		view 991
		loop 2
		cel 0
		cursor 1
		message 2
		signal $0081
		helpStr {Chcete-li se podívat blíže na nìjaký pøedmìt z vašeho inventáøe, kliknìte nejprve sem, a potom kliknìte na daný pøedmìt.}
	)
	
	(method (init)
		(= highlightColor 0)
		(= lowlightColor gLowlightColor_2)
		(super init:)
	)
)

(instance invHand of LLIconItem
	(properties
		view 991
		loop 0
		cel 0
		cursor 2
		message 3
		helpStr {Chcete-li nìco udìlat s nìjakým pøedmìtem ve vašem inventáøi, kliknìte nejprve sem, a pak kliknìte na daný pøedmìt.}
	)
	
	(method (init)
		(= highlightColor 0)
		(= lowlightColor gLowlightColor_3)
		(super init:)
	)
)

(instance invHelp of LLIconItem
	(properties
		view 991
		loop 1
		cel 0
		cursor 9
		message 6
		helpStr {Chcete-li se dozvìdìt nìco o ostatních ikonách v tomto oknì, kliknìte nejprve sem, a potom nad ikony pøesuòte otazník.}
	)
	
	(method (init)
		(= highlightColor 0)
		(= lowlightColor gLowlightColor_4)
		(super init:)
	)
)

(instance invSelect of LLIconItem
	(properties
		view 991
		loop 4
		cel 0
		cursor 999
		helpStr {Chcete-li použít nìkterý z pøedmìtù v inventáøi ve høe, kliknìte nejprve sem, pak kliknìte na daný pøedmìt a poté na OK.}
	)
	
	(method (init)
		(= highlightColor 0)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
)

(instance Kamera of InvI
	(properties
		view 931
		cursor 931
		signal $0002
		description {kamera}
	)
	
	(method (doVerb theVerb theState &tmp [temp0 50] temp50 temp51)
		(= temp50 (mod state 100))
		(switch theVerb
			(2
				(proc0_14 19 0 70 250 80 name)
				(Format
					@temp0
					19
					1
					(if (>= state 100) {Zap} else {Vyp})
					(/ (gCamcorderTimer seconds?) 60)
					(mod (gCamcorderTimer seconds?) 60)
				)
				(proc0_14 @temp0 70 123 30 1 80 name)
			)
			(3
				(cond 
					((>= state 100)
						(= state (- state 100))
						(proc0_14 19 2)
						(Format
							@temp0
							19
							3
							(/ (gCamcorderTimer seconds?) 60)
							(mod (gCamcorderTimer seconds?) 60)
						)
						(proc0_14 @temp0)
					)
					((and temp50 (gCamcorderTimer seconds?))
						(= state (+ state 100))
						(proc0_10 4 72)
						(proc0_14 19 4)
						(Format
							@temp0
							19
							3
							(/ (gCamcorderTimer seconds?) 60)
							(mod (gCamcorderTimer seconds?) 60)
						)
						(proc0_14 @temp0)
					)
					(temp50 (proc0_14 19 5))
					(else (proc0_14 19 6))
				)
			)
			(4
				(if (proc999_5 theState 2 3 4)
					(if temp50
						(proc0_14 19 7)
						((Inv at: temp50) owner: 23)
					)
					(if (!= ((Inv at: theState) state?) 1)
						(proc0_14 19 8)
						(proc0_14 19 9 67 -1 185)
						(= state 0)
					else
						(proc0_10 4 73)
						(proc0_14 19 10)
						(= state theState)
						((Inv at: theState) owner: Kamera)
						(Inv curIcon: 0 hide:)
						(gLarry showInv:)
					)
				else
					(localproc_008a (Inv indexOf: self) theState)
				)
			)
			(else 
				(super doVerb: theVerb theState &rest)
			)
		)
	)
)

(instance Battery_Charger of InvI
	(properties
		view 932
		cursor 932
		signal $0002
		description {nabíjeèka baterií}
		name "Nabíjeèka baterií"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 11 80 name))
			(3 (proc0_14 19 12))
			(4
				(switch param2
					(0 (proc0_14 19 13))
					(else 
						(localproc_008a (Inv indexOf: self) param2)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_a of InvI
	(properties
		view 934
		cursor 934
		signal $0002
		description {videokazeta}
		name "Vymazaná videokazeta"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch state
					(0
						(proc0_14 19 14 80 name 30 1)
					)
					(1 (proc0_14 19 15 80 name))
					(2 (proc0_14 19 16 80 name))
					(3 (proc0_14 19 17 80 name))
					(4 (proc0_14 19 18 80 name))
				)
			)
			(3 (proc0_14 19 19))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_b of InvI
	(properties
		view 934
		cursor 934
		signal $0002
		description {videokazeta}
		name "Vymazaná videokazeta"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch state
					(0
						(proc0_14 19 14 80 name 30 1)
					)
					(1 (proc0_14 19 15 80 name))
					(2 (proc0_14 19 16 80 name))
					(3 (proc0_14 19 17 80 name))
					(4 (proc0_14 19 18 80 name))
				)
			)
			(3 (proc0_14 19 20))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance A_Blank_Videotape_c of InvI
	(properties
		view 934
		cursor 934
		signal $0002
		description {videokazeta}
		name "Vymazaná videokazeta"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch state
					(0
						(proc0_14 19 14 80 name 30 1)
					)
					(1 (proc0_14 19 15 80 name))
					(2 (proc0_14 19 16 80 name))
					(3 (proc0_14 19 17 80 name))
					(4 (proc0_14 19 18 80 name))
				)
			)
			(3 (proc0_14 19 21))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Michelle_Milken_s_Resume of InvI
	(properties
		view 937
		cursor 937
		signal $0002
		description {Michellin životopis}
		name "Životopis Michelle Milkenové"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 22 33 global173 82 937 2 1 80 name)
				(proc0_14 19 23 33 global173 70 222 80 name)
				(if
				(not (proc999_5 (Hard_Disk_Cafe_Napkin owner?) 23 510))
					(proc0_10 1 69)
					(proc0_14 19 24)
					(gLarry get: 6)
					(Inv curIcon: 0 hide:)
					(gLarry showInv:)
				)
			)
			(3
				(proc0_14 19 25)
				(self doVerb: 2)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Hard_Disk_Cafe_Napkin of InvI
	(properties
		view 938
		cursor 938
		signal $0002
		description {Ubrousek z kavárny Hard Disk}
		name "Ubrousek z kavárny Hard Disk"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 26 80 name 70 222 30 1)
			)
			(3 (proc0_14 19 27))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance AeroDork_Gold_Card of InvI
	(properties
		view 939
		cursor 939
		signal $0002
		description {zlatá karta AeroBlb}
		name "Zlatá karta AeroBlb"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 28 80 name))
			(3 (proc0_14 19 29))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Boarding_Pass of InvI
	(properties
		view 940
		cursor 940
		signal $0002
		description {Palubní lístek}
		name "Palubní lístek"
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 200] temp200 temp201 temp202 temp203)
		(switch theVerb
			(2
				(= temp202 (& (= temp200 (GetTime 3)) $001f))
				(= temp201 (& (>> temp200 $0005) $000f))
				(= temp203 (+ (>> temp200 $0009) 1980))
				(Format
					@temp0
					19
					30
					(switch global160
						(0 {L.A.})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
					(switch state
						(0 {L.A.})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
					(/ global177 100)
					(mod global177 100)
					[local0 temp201]
					temp202
					temp203
				)
				(proc0_14 @temp0 80 name)
			)
			(3 (proc0_14 19 31))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance AeroDork_s_In-Flight_Magazine of InvI
	(properties
		view 941
		cursor 941
		signal $0002
		description {èasopis}
		name "Letový èasopis AeroBlb"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 32 80 name))
			(3
				(proc0_14 19 33)
				(proc0_10 5 68)
				(proc0_14 19 34)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Some_Change of InvI
	(properties
		view 942
		cursor 942
		signal $0002
		description {ètvrák}
		name "Ètvrák"
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 40])
		(switch theVerb
			(2
				(Format @temp0 19 35 (* global168 2))
				(proc0_14 @temp0 80 name)
			)
			(3
				(Format
					@temp0
					19
					36
					(if (Random 0 1) {hlava} else {panna})
				)
				(proc0_14 @temp0)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance DayTrotter_ of InvI
	(properties
		view 943
		cursor 943
		signal $0002
		description {diáø}
		name "DayTrotter"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if state
					(proc0_14 19 37 80 name)
				else
					(proc0_10 11 74)
					(proc0_14 19 38 80 name)
					(Inv curIcon: 0 hide:)
					(= state 1)
					(gLarry get: 12 13 showInv:)
				)
			)
			(3
				(if state
					(proc0_14 19 39 80 name)
				else
					(self doVerb: 2)
				)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Money of InvI
	(properties
		view 944
		cursor 944
		signal $0002
		description {peníze}
		name "Peníze"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 40 80 name))
			(3 (proc0_14 19 41))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Credit_Cards of InvI
	(properties
		view 945
		cursor 945
		signal $0002
		description {kreditní karty}
		name "Kreditní karty"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 42 80 name))
			(3 (proc0_14 19 43))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Membership_Tape of InvI
	(properties
		view 946
		cursor 946
		signal $0002
		description {èlenská páska}
		name "Èlenská páska"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch state
					(1 (proc0_14 19 44 80 name))
					(2 (proc0_14 19 45 80 name))
					(3 (proc0_14 19 46 80 name))
				)
			)
			(3 (proc0_14 19 47))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance DataMan of InvI
	(properties
		view 948
		cursor 948
		signal $0002
		description {DataMan}
		owner 445
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch state
					(0 (proc0_14 19 48 80 name))
					(1
						(proc0_14 19 49 80 name 30 1)
						(proc0_7 17)
					)
					(2
						(proc0_10 1 78)
						(proc0_14 19 50 80 name 30 1)
					)
				)
			)
			(3
				(switch state
					(0 (proc0_14 19 51))
					(1
						(= state 0)
						(proc0_14 19 52)
						(Reverse_Biaz_DataPak owner: 24)
						(Inv curIcon: 0 hide:)
						(gLarry showInv:)
					)
					(2
						(= state 0)
						(proc0_14 19 53)
						(P__C__Hammer_DataPak owner: 24)
						(Inv curIcon: 0 hide:)
						(gLarry showInv:)
					)
				)
			)
			(4
				(switch param2
					(1
						(proc0_10 7 75)
						(if (== (DataMan state?) 0)
							(proc0_14 19 54)
							(= state 1)
							(Reverse_Biaz_DataPak owner: self)
							(Inv curIcon: 0 hide:)
							(gLarry showInv:)
						else
							(proc0_14 19 55)
						)
					)
					(2
						(proc0_10 7 75)
						(if (== (DataMan state?) 0)
							(proc0_14 19 56)
							(= state 2)
							(P__C__Hammer_DataPak owner: self)
							(Inv curIcon: 0 hide:)
							(gLarry showInv:)
						else
							(proc0_14 19 55)
						)
					)
					(else 
						(localproc_008a (Inv indexOf: self) param2)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Reverse_Biaz_DataPak of InvI
	(properties
		view 949
		cursor 949
		signal $0002
		description {DataPak: Reverse Biaz}
		owner 445
		name "DataPak: Reverse Biaz"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 57 80 name 30 1)
			)
			(3 (proc0_14 19 58))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance P__C__Hammer_DataPak of InvI
	(properties
		view 949
		cursor 949
		signal $0002
		description {DataPak: P. C. Hammer}
		owner 445
		name "DataPak: P. C. Hammer"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 59 80 name 30 1)
			)
			(3 (proc0_14 19 58))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Lana_Luscious__Resume of InvI
	(properties
		view 937
		cursor 937
		signal $0002
		description {Lanin životopis}
		name "Životopis Lany Lahodné"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 60 33 global173 82 937 2 2 80 name)
				(proc0_14 19 61 33 global173 70 277 80 name)
				(if (not (gLarry has: 16))
					(proc0_10 1 70)
					(proc0_14 19 62)
					(gLarry get: 16)
					(Inv curIcon: 0 hide:)
					(gLarry showInv:)
				)
			)
			(3
				(proc0_14 19 63)
				(self doVerb: 2)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Tramp_Casino_Matchbook of InvI
	(properties
		view 952
		cursor 952
		signal $0002
		description {krabièka zápalek z Trampova kasina}
		name "Krabièka zápalek z Trampova kasina"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 64 80 name 30 1)
			)
			(3
				(proc0_14 19 65)
				(proc0_14 19 66 67 -1 185)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Silver_Dollar of InvI
	(properties
		view 953
		cursor 953
		signal $0002
		description {støíbrný dolar}
		name "Støíbrný dolar"
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 200])
		(switch theVerb
			(2
				(Format
					@temp0
					19
					67
					global153
					(if (> global153 1) {s} else {})
				)
				(proc0_14 @temp0 80 name)
				(proc0_14 19 68)
			)
			(3 (proc0_14 19 69))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Roller-skates of InvI
	(properties
		view 954
		cursor 954
		signal $0002
		description {koleèkové brusle}
		name "Koleèkové brusle"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 70 80 name))
			(3
				(if (== gNumber 760)
					((ScriptID 760 1) doVerb: 4 18)
				else
					(proc0_14 19 71)
				)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Reverse_Biaz_Fax of InvI
	(properties
		view 955
		cursor 955
		signal $0002
		description {fax ohlednì Reverse Biaze}
		name "Fax ohlednì Reverse Biaze"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 49 80 name 30 1)
				(proc0_7 17)
			)
			(3 (proc0_14 19 72))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Champagne of InvI
	(properties
		view 956
		cursor 956
		signal $0002
		description {šampaòské}
		name "Šampaòské"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 73 80 name))
			(3 (proc0_14 19 74))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Gold_Record of InvI
	(properties
		view 957
		cursor 957
		signal $0002
		description {zlatá deska}
		name "Zlatá deska"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if state
					(proc0_14 19 75 80 name)
				else
					(proc0_14 19 76 80 name)
				)
			)
			(3 (proc0_14 19 77))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Cassette_Tape of InvI
	(properties
		view 958
		cursor 958
		signal $0002
		description {kazeta}
		name "Kazeta"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 78 80 name))
			(3 (proc0_14 19 79))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Chi_Chi_Lambada_s_Resume of InvI
	(properties
		view 937
		cursor 937
		signal $0002
		description {Chi Chin životopis}
		name "Životopis Chi Chi Lambady"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 80 33 global173 82 937 2 0 80 name)
				(proc0_14 19 81 33 global173 70 240 80 name)
				(if (not (gLarry has: 20))
					(proc0_10 1 71)
					(proc0_14 19 82)
					(gLarry get: 20)
					(Inv curIcon: 0 hide:)
					(gLarry showInv:)
				)
			)
			(3
				(proc0_14 19 83)
				(self doVerb: 2)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Doc_Pulliam_s_Card of InvI
	(properties
		view 960
		cursor 960
		signal $0002
		description {vizitka doktora Vytlhala}
		name "Vizitka doktora Vytlhala"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_10 1 77)
				(proc0_14 19 84 80 name 70 222 30 1)
			)
			(3
				(proc0_14 19 85)
				(proc0_14 19 86)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Green_Card of InvI
	(properties
		view 961
		cursor 961
		signal $0002
		description {zelená karta}
		name "Zelená karta"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 87 80 name))
			(3 (proc0_14 19 88))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Doily of InvI
	(properties
		view 962
		cursor 962
		signal $0002
		description {ubrousek}
		name "Šála"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 89 80 name)
				(proc0_14 19 90 67 -1 185 80 name)
				(proc0_14 19 91 67 -1 185 80 name)
			)
			(3
				(cond 
					((!= gNumber 905) (proc0_14 19 92))
					((gLarry sitting?) (proc0_14 19 93))
					(else
						(if state
							(gLarry
								view: 907
								setLoop: 4
								setCel: 255
								cycleSpeed: 10
								setCycle: Beg global2
							)
							(proc0_14 19 94)
						else
							(gLarry
								view: 907
								setLoop: 4
								setCel: 0
								cycleSpeed: 10
								setCycle: End global2
							)
							(proc0_10 8 159)
							(proc0_14 19 95)
						)
						(= state (not state))
					)
				)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance P__C__Hammer_Fax of InvI
	(properties
		view 955
		cursor 955
		signal $0002
		description {fax ohlednì P. C. Hammera}
		name "Fax ohlednì P. C. Hammera"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 19 96 80 name 70 200 30 1)
			)
			(3 (proc0_14 19 72))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Letter_Opener of InvI
	(properties
		view 964
		cursor 964
		signal $0002
		description {nùž na dopisy}
		name "Nùž na dopisy"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 97 80 name))
			(3 (proc0_14 19 98))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Desk_Key of InvI
	(properties
		view 965
		cursor 965
		signal $0002
		description {klíè od stolu}
		name "Klíè od stolu"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 99 80 name))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Folder_Of_Evidence of InvI
	(properties
		view 966
		cursor 966
		signal $0002
		description {složka s dùkazy}
		name "Složka s dùkazy"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_10 4 146)
				(proc0_14 19 100 80 name)
				(proc0_14 19 101 80 name)
			)
			(3
				(if (gLarry has: 11)
					(proc0_14 19 102)
				else
					(proc0_14 19 103)
				)
			)
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Photocopied_Evidence of InvI
	(properties
		view 967
		cursor 967
		signal $0002
		description {fotokopie}
		name "Fotokopie Dùkazú"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 19 104 80 name))
			(3 (proc0_14 19 105))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Reel_To_Reel_Tape of InvI
	(properties
		view 968
		cursor 968
		signal $0002
		description {páska z kotouèové cívky}
		name "Páska z kotouèové cívky"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if state
					(proc0_14 19 106 80 name)
				else
					(proc0_14 19 107 80 name)
					(proc0_14 19 108 67 -1 185)
				)
			)
			(3 (proc0_14 19 109))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Hooter_Shooter of InvI
	(properties
		view 969
		cursor 969
		signal $0002
		description {podprsenka "Hooter Shooter"}
		name "Podprsenka 'Hooter Shooter'"
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_10 2 76)
				(proc0_14 19 110 80 name)
			)
			(3 (self doVerb: 2))
			(4
				(localproc_008a (Inv indexOf: self) param2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
