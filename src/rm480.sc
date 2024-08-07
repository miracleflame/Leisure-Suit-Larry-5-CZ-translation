;;; Sierra Script 1.0 - (do not remove this comment)
(script# 480)
(include sci.sh)
(use Main)
(use LLRoom)
(use n940)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm480 0
)

(local
	local0
	[local1 29] = [0 273 274 275 297 467 387 147 161 291 861 911 146 892 752 753 754 755 756 751 526 851 482 483 484]
	local30
)
(procedure (localproc_0a0f param1 param2 &tmp temp0 temp1)
	(global2 drawPic: 1 13)
	(= temp1
		(switch (Random 0 5)
			(0 global131)
			(1 gLowlightColor_5)
			(2 global138)
			(3 global142)
			(4 gLowlightColor)
			(else  global146)
		)
	)
	(Display
		param1
		dsCOLOR
		temp1
		dsCOORD
		1
		(- 89 (/ (* 12 param2) 2))
		dsWIDTH
		318
		dsFONT
		global26
		dsALIGN
		1
	)
)

(instance rm480 of LLRoom
	(properties
		picture 480
		style $0007
	)
	
	(method (init)
		(proc958_0 129 1)
		(proc958_0 135 global174)
		(proc958_0 132 100)
		(copter init: setCycle: Fwd)
		(super init:)
		(if (proc0_6 47)
			(gLongSong
				number: 462
				flags: 1
				setLoop: -1
				setVol: 127
				play:
			)
		)
		(gLongSong2
			number: 468
			flags: 1
			setLoop: -1
			setVol: 127
			play:
		)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gLongSong fade: 0 15 12 1)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 3))
			(1
				(proc0_18 gLarry 480 0 108 self 67 -1 20)
			)
			(2
				(proc0_14 480 1 80 {Larry} 108 self 67 -1 20)
			)
			(3
				(proc0_18 gLarry 480 2 108 self 67 -1 20)
			)
			(4
				(proc0_14 480 3 80 {Viceprezident} 108 self 67 -1 20)
			)
			(5
				(proc0_14 480 4 80 {Larry} 108 self 67 -1 20)
			)
			(6
				(proc0_18 gLarry 480 5 108 self 67 -1 20)
			)
			(7
				(copter setLoop: 0 setCycle: End self)
			)
			(8
				(copter
					cycleSpeed: 8
					setLoop: 1
					setCel: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: End self
					setMotion: MoveTo 165 128
				)
			)
			(9
				(copter
					x: 285
					y: 79
					xStep: 7
					yStep: 7
					setLoop: 2
					setCel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 350 61 self
				)
				(gLongSong2 fade:)
			)
			(10 (= ticks 120))
			(11
				(gLongSong fade: 0 15 12 1 self)
			)
			(12
				(gLongSong
					number: 100
					flags: 1
					setLoop: -1
					setVol: 127
					play:
				)
				(= ticks 120)
			)
			(13
				(proc0_14 480 6 67 -1 20)
				(proc0_14 480 7)
				(= seconds 3)
			)
			(14
				(proc0_14 480 8 67 -1 15 70 280)
				(proc0_14 480 9)
				(= seconds 3)
			)
			(15
				(proc0_14 480 10 67 -1 15 70 280)
				(proc0_14 480 11)
				(= seconds 3)
			)
			(16
				(proc0_14 480 12 67 -1 15 70 280)
				(proc0_14 480 13)
				(= seconds 3)
			)
			(17
				(proc0_14 480 14 67 -1 15 70 280)
				(proc0_14 480 15)
				(= seconds 3)
			)
			(18
				(proc0_14 480 16 67 -1 15 70 280)
				(proc0_14 480 17)
				(= seconds 3)
			)
			(19
				(proc0_14 480 18 67 -1 15 70 280)
				(proc0_14 480 19)
				(= seconds 3)
			)
			(20
				(proc0_14 480 20 67 -1 15 70 280)
				(= seconds 3)
			)
			(21
				(proc0_14 480 21)
				(= seconds 3)
			)
			(22
				(proc0_14 480 22 67 -1 185)
				(= seconds 3)
			)
			(23
				(localproc_0a0f {Mana�er v�tvarn�ho t�mu\n\nCheryl Loyd} 3)
				(= seconds 3)
			)
			(24
				(global2 drawPic: 1 13)
				(= local30
					(switch (Random 0 5)
						(0 global131)
						(1 gLowlightColor_5)
						(2 global138)
						(3 global142)
						(4 gLowlightColor)
						(else  global146)
					)
				)
				(Display
					{Anim�to�i\n\n}
					dsCOLOR
					local30
					dsCOORD
					1
					35
					dsWIDTH
					318
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\nCheryl Loyd\nBarry T. Smith\nRoger Hardy Jr.\nDana M. Dean\nKarin Young\nMarc Hudgins\nEric Kasner}
					dsCOLOR
					local30
					dsCOORD
					1
					35
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\nRichard Powell\nPhyllis Cucchiara\nTerry Falls\nMichael Hutchison\nDesie Hartman\nWillis Wong}
					dsCOLOR
					local30
					dsCOORD
					161
					35
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(= seconds 8)
			)
			(25
				(localproc_0a0f
					{Grafika pozad�\n\nJane Cardinal\nMaurice Morgan\nAndy Hoyos\nCheryl Loyd\nJay Friedmann\nJennifer Shontz\nGloria Garland}
					9
				)
				(= seconds 5)
			)
			(26
				(localproc_0a0f
					{Program�to�i\n\nBrian K. Hughes\nCarlos Escobar\nSteve Conrad\nJohn Hartin\nOliver Brelsford\nAl Lowe}
					8
				)
				(= seconds 5)
			)
			(27
				(localproc_0a0f {Hudebn� re�ie\n\nMark Seibert} 3)
				(= seconds 3)
			)
			(28
				(global2 drawPic: 1 13)
				(= local30
					(switch (Random 0 5)
						(0 global131)
						(1 gLowlightColor_5)
						(2 global138)
						(3 global142)
						(4 gLowlightColor)
						(else  global146)
					)
				)
				(Display
					{Sierra's Creative Interpreter\nV�vojov� syst�m\n\n}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					318
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\nJeff Stephenson\nRobert E. Heitman\nDan Foy\nLarry Scott\nJohn Rettig\nJ. Mark Hood\nChris Smith\nTerry McHenry}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\nEric Hart\nChad Bye\nMark Wilden\nKen Koch\nJohn Crane\nSteve Coallier\nRandy Moss}
					dsCOLOR
					local30
					dsCOORD
					161
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(= seconds 8)
			)
			(29
				(localproc_0a0f {Dodate�n� hudba\n\nChris Braymen} 3)
				(= seconds 3)
			)
			(30
				(localproc_0a0f
					{Dodate�n� p�semn� materi�l\n\nJosh Mandel}
					3
				)
				(= seconds 3)
			)
			(31
				(localproc_0a0f
					{Vedouc� t�mu pro zaji�t�n� kvality\n\nRobin Bradley}
					3
				)
				(= seconds 3)
			)
			(32
				(global2 drawPic: 1 13)
				(= local30
					(switch (Random 0 5)
						(0 global131)
						(1 gLowlightColor_5)
						(2 global138)
						(3 global142)
						(4 gLowlightColor)
						(else  global146)
					)
				)
				(Display
					{Vedouc� projektu �esk� lokalizace\n
					\n
					Jan "Jennza" Dlaba�\n
					\n
					\n
					P�ekladatel�}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					318
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\n\n\n\n\n
					Petr Cejpek\n
					Hynek\n
					Libor Pavl�\n
					Marek "Drekorian" Osvald\n
					Rafina\n
					Tom� Hru�ka
					}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\n\n\n\n\n
					Mirek "miracle.flame" J.\n
					Tikky\n
					Jan "Jennza" Dlaba�\n
					JaSpin\n
					Martin "hlahol" �.\n}
					dsCOLOR
					local30
					dsCOORD
					161
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(= seconds 8)			
			)
			(33
				(localproc_0a0f
					{Technick� podpora\n
					\n
					Sl�vek Juna\n
					Mirek "miracle.flame" J.\n
					Zhilian\n
					\n
					\n
					Test a korekce\n
					\n
					Petr Cejpek\n
					Mirek "miracle.flame" J.\n\n\n\n\n}
					3
				)
				(= seconds 5)
			)
			(34
				(localproc_0a0f {Ml�nek na k�vu\n\nC. Escobar} 3)
				(= ticks 100)
			)
			(35
				(if (DoSound sndSET_SOUND)
					(gLongSong2 number: 161 setLoop: 1 play:)
				)
				(= seconds 3)
			)
			(36
				(global2 drawPic: 1 13)
				(if (DoSound sndSET_SOUND)
					(proc0_14 480 23 80 {AL ��k�} 67 -1 20)
				)
				(= seconds 5)
			)
			(37 (gLongSong fade: self))
			(38
				(if (not (DoSound sndSET_SOUND))
					(= state (+ state 1))
				else
					(gGame setCursor: 999 1)
					(proc0_14
						480
						24
						80
						{Gratulujeme! Vyhr�li jste!!!}
						67
						-1
						15
						70
						280
					)
				)
				(= cycles 2)
			)
			(39
				(if
					(= local0
						(proc940_0
							{Nejste r�di, �e jste si koupili p�evodn�k digital-analog?}
							4
							50
							106
							81
							{___Leti�t� #1___}
							1
							81
							{___Leti�t� #2___}
							2
							81
							{___Leti�t� #3___}
							3
							106
							81
							{__Leti�t� #4__}
							4
							81
							{____Dav lid�____}
							5
							81
							{_____V�k�iky_____}
							6
							106
							81
							{______Jauu______}
							7
							81
							{______K�va______}
							8
							81
							{_Skl�dac� �idle_}
							9
							106
							81
							{Obdivn� hvizd}
							10
							81
							{____Klep�n�_____}
							11
							81
							{_____Sklo #1_____}
							12
							106
							81
							{____Sklo #2____}
							13
							81
							{_______Au_______}
							14
							81
							{_________Ou_________}
							15
							106
							81
							{_______AH!______}
							16
							81
							{______OU!_______}
							17
							81
							{_______Uuuu!________}
							18
							106
							81
							{Dav lap� po dechu}
							19
							81
							{Burani j�}
							20
							81
							{__Splachov�n�__}
							21
							106
							81
							{____��hnut�____}
							22
							81
							{___Zvracen�___}
							23
							81
							{________Prd________}
							24
							106
							81
							{< Hotovo >}
							0
							4
							107
							80
							{D�kujeme, �e jste si koupili "Larryho 5"!}
							121
							local0
						)
					)
					(gLongSong number: [local1 local0] setLoop: 1 play:)
					(self changeState: state)
				else
					(= cycles 1)
				)
			)
			(40
				(global2 drawPic: 1 13)
				(Display
					{Pamatujte na slogan Ala Lowa:}
					dsCOLOR
					gLowlightColor_6
					dsCOORD
					1
					30
					dsWIDTH
					318
					dsFONT
					global175
					dsALIGN
					1
				)
				(= cycles 2)
			)
			(41
				(if (DoSound sndSET_SOUND) (proc958_0 132 481))
				(= seconds 3)
			)
			(42
				(if (DoSound sndSET_SOUND)
					(gLongSong number: 481 setVol: 127 setLoop: 1 play:)
				)
				(Display
					{Lep�� baby d�ky\ntechnologii!}
					dsCOLOR
					global131
					dsCOORD
					1
					90
					dsWIDTH
					318
					dsFONT
					global174
					dsALIGN
					1
				)
				(= seconds 5)
			)
			(43 (= global4 1))
		)
	)
)

(instance copter of Actor
	(properties
		x 160
		y 144
		view 480
		loop 3
	)
)
